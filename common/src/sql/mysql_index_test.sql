--建表语句
CREATE TABLE `u_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `truename` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gender` tinyint(4) DEFAULT '0',
  `status` tinyint(4) DEFAULT '0',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `qq` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_name_phone` (`username`,`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2104064 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

--存储过程，批量初始化数据
DELIMITER $$

USE `test_dubbo`$$

DROP PROCEDURE IF EXISTS `insertUser`$$

CREATE DEFINER=`dev`@`%` PROCEDURE `insertUser`()
BEGIN
  DECLARE var INT ;
  DECLARE UN VARCHAR (255) ;
  DECLARE TN VARCHAR (255) ;
  DECLARE PH VARCHAR (255) ;
  DECLARE EM VARCHAR (255) ;
  DECLARE ADDR VARCHAR (255) ;
  DECLARE QQ VARCHAR (255) ;
  SET var = 0 ;
  WHILE
    var < 2000000 DO SET UN = CONCAT('测试用户', var) ;
    SET TN = CONCAT('用户', var) ;
    SET PH = CONCAT('18510841', var) ;
    SET EM = CONCAT('yyddd@aliyun.com', var) ;
    SET ADDR = CONCAT( '北京市东城区白桥大街', var, '号' ) ;
    SET QQ = CONCAT('883838', var, '号') ;
    INSERT INTO u_user (
      username,
      PASSWORD,
      truename,
      phone,
      email,
      gender,
      STATUS,
      address,
      qq,
      last_login_time
    )
    VALUES
      (UN, NULL, TN, PH, EM, 1, 1, ADDR, QQ, NULL) ;
    SET var = var + 1 ;
  END WHILE ;
END$$

DELIMITER ;


--覆盖索引的优化

--查询列中包含未索引字段，没有覆盖索引，会产生回表查询（测试结果：200万数据，4.77s）
EXPLAIN
SELECT username, phone, email,STATUS,createtime, updatetime FROM u_user WHERE username LIKE '测%' GROUP BY username, phone ORDER BY username, phone LIMIT 1000000, 10;

--查询列中包含所有索引字段，覆盖索引，不会回表查询，效率高（测试结果：200万数据，2.19s）
EXPLAIN
SELECT username, phone FROM u_user WHERE username LIKE '测%' GROUP BY username, phone ORDER BY username, phone LIMIT 1000000, 10;

--查询列中包含未索引字段，没有覆盖索引，会产生回表查询（测试结果：200万数据，4.77s）
EXPLAIN
SELECT email FROM u_user WHERE username LIKE '测%' GROUP BY username, phone ORDER BY username, phone LIMIT 1000000, 10;

--虽然使用了索引，但是由于排序列排序顺序不一致，会导致使用临时表、filesort，严重拖慢速度（测试结果：200万数据，几分钟都没执行完）
EXPLAIN
SELECT username, phone FROM u_user WHERE username LIKE '测%' GROUP BY username, phone ORDER BY username DESC, phone LIMIT 1000000, 10;

--排序列排序一致，并覆盖索引，效率高（测试结果：200万数据，2.16s）
EXPLAIN
SELECT username, phone FROM u_user WHERE username LIKE '测%' GROUP BY username, phone ORDER BY username DESC, phone DESC LIMIT 1000000, 10;

--对第一条sql优化，在右表中使用到了覆盖索引扫描，大大减少关联查询时的扫描数量。（测试结果：200万数据，2.44s）
EXPLAIN
SELECT
  username,
  phone,
  email,
  STATUS,
  createtime,
  updatetime
FROM
  u_user u
  JOIN
    (SELECT
      id
    FROM
      u_user
    WHERE username LIKE '测%'
    GROUP BY username,
      phone
    ORDER BY username,
      phone
    LIMIT 1000000, 10) t
    ON u.id = t.id ;

