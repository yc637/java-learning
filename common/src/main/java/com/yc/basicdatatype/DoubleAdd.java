package com.yc.basicdatatype;

/**
 * double类型精度问题
 *
 * @author gs
 * @date 2019年03月27日 16:16:37
 */
public class DoubleAdd {

    public static void main(String[] args) {
        double a = 0.1;
        double b = 0.2;
        // 0.30000000000000004
        System.out.println(a + b);
    }
}
