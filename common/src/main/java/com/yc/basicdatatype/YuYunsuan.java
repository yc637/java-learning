package com.yc.basicdatatype;

/**
 * 与运算，移位运算
 * 一：与运算符（&）
 * 预算规则：
 *
 * 0&0=0；0&1=0；1&0=0；1&1=1
 *
 * 即：两个同时为1，结果为1，否则为0
 *
 * 例如：3&5
 *
 * 十进制3转为二进制的3：0000 0011
 *
 * 十进制5转为二进制的5：0000 0101
 *
 * ------------------------结果：0000 0001 ->转为十进制：1
 *
 * 即：3&5 = 1
 *
 * 二：或运算（|）
 * 运算规则：
 *
 * 0|0=0；  0|1=1；  1|0=1；   1|1=1；
 *
 * 即 ：参加运算的两个对象，一个为1，其值为1。
 *
 * 例如：3|5　即 00000011 | 0000 0101 = 00000111，因此，3|5=7。　
 *
 * 三：异或运算符（^）
 * 运算规则：0^0=0；  0^1=1；  1^0=1；   1^1=0；
 *
 * 即：参加运算的两个对象，如果两个位为“异”（值不同），则该位结果为1，否则为0。
 *
 * 例如：3^5 =  0000 0011 | 0000 0101 =1111 0110，因此，3^5 = 246
 * ————————————————
 * 版权声明：本文为CSDN博主「一个字涨」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_39416311/article/details/102762635
 *
 * @author gs
 * @date 2019年08月02日 18:18:04
 */
public class YuYunsuan {
    public static void main(String[] args) {
        // 5的二进制为0000 0101，7的二进制0000 0111， 5&7=0000 0101=5
        System.out.println(5 & 7);



        // 等价于14/2
        System.out.println(14 >> 1);
        // 等价于16除以2的4次方
        System.out.println(16 >> 4);
        // 等价于3乘以2的4次方
        System.out.println(3 << 4);


        // 二进制101010第5位
        long a = 0b010;
        System.out.println(a);
        System.out.println(42 >> 3) ;


    }
}
