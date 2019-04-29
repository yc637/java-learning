package com.yc.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 文字描述
 *
 * @author gs
 * @date 2018年11月23日 10:10:45
 */
public class ArrayListSizeTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10000);
        System.out.println(list.size());
    }
}
