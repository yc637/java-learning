package com.yc.basicdatatype;

/**
 * 与运算，移位运算
 *
 * @author gs
 * @date 2019年08月02日 18:18:04
 */
public class YuYunsuan {
    public static void main(String[] args) {
        System.out.println(5 & 7);
        // 等价于14/2
        System.out.println(14 >> 1);
        // 等价于16除以2的4次方
        System.out.println(16 >> 4);
        // 等价于3乘以2的4次方
        System.out.println(3 << 4);
    }
}
