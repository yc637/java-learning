package com.yc.basicdatatype;

import java.util.Objects;

/**
 * 文字描述
 *
 * @author gs
 * @date 2017年05月19日 12:12:21
 */
public class IntegerInt {

    private Integer i;
    private Integer j;
    private int x;
    private int y;

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static void main(String[] args) {
//        Integer i = null;
//        int j = i;
//        System.out.println(j);


        // Integer将[-128，127]的数字进行缓存，所以获取该范围内的Integer对象时，是从缓存中获取，故而是相同的对象。
        // Integer i = 1;的实现原理是：Integer i = Integer.valueOf(1);
        Integer i1 = 1;
        Integer i2 = 1;
        Integer i3 = 130;
        Integer i4 = 130;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);

        // 当new一个Integer对象时，是直接在堆中创建对象，没有适用缓存
        Integer i5 = new Integer(1);
        Integer i6 = new Integer(1);
        System.out.println(i5 == i6);

        // Integer和int类型相比较时，会自动拆箱，实际比较的是int值
        int i7 = 1;
        Integer i8 = 1;
        Integer i9 = new Integer(1);
        System.out.println(i7 == i8);
        System.out.println(i7 == i9);


        // 定义了两个Integer成员变量a=1，b=2. 现在需要通过swap方法把a和b的值做一个交换，交换以后输出的结果是a=2，b=1.
        Integer a=150, b=160;
        swap1(a, b);
        System.out.println("a="+a.intValue() + "b="+b.intValue());


        //
        IntegerInt integerInt = new IntegerInt();
        integerInt.setI(1);
        integerInt.setJ(2);
        change(integerInt);
        System.out.println("IntegerInt成员变量i="+integerInt.getI()+"j="+integerInt.getJ());

        //
        IntegerInt integerInt2 = new IntegerInt();
        integerInt.setX(1);
        integerInt.setY(2);
        change2(integerInt);
        System.out.println("IntegerInt成员变量x="+integerInt.getX()+"y="+integerInt.getY());

    }

    // 运行后swap中的a=2b=1，main中a=1b=2，并没有实现交换
    // 因为i1和i2传过来的是参数的副本，并不是对象的地址
    // 原因是Integer中value是final修饰，不可更改
    // 包装类型和String类似，都是每次都new一个新对象
    public static void swap1(Integer i1, Integer i2) {
        System.out.println("i1的hashcode："+i1.hashCode());
        System.out.println("12的hashcode："+i2.hashCode());
        System.out.println(i1);
        Integer temp = i1;
        i1 = i2;
        i2 = temp;
        System.out.println("swap中的i1="+i1+"i2="+i2);
    }

    //
    public static void swap2(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
        System.out.println("swap中的a="+a+"b="+b);
    }

    public static void change(IntegerInt integerInt) {
        System.out.println("integerInt的hashcode："+integerInt.hashCode());
        integerInt.setI(2);
        integerInt.setJ(1);
    }

    private static void change2(IntegerInt integerInt) {
        integerInt.setX(2);
        integerInt.setY(1);
    }

}
