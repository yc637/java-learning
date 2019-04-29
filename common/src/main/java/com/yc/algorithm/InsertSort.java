package com.yc.algorithm;

/**
 * 插入排序 基本原理：将元素依次插入到已经排定的有序数之中 初始时，取首个元素，可以认为该元素本身是一个有序队列，就相当于是待排序的数组中只有一个元素时，该元素本事就有序
 * 再从后面依次取出元素，与已排序的所有元素比较，插入到合适的位置，以此类推
 *
 * 本例中，定义的方法可以作为其他排序算法的模板进行使用（参考《算法第四版》）
 * 
 * @author gs
 * @date 2018年08月17日 16:16:59
 */
public class InsertSort {

    public static void main(String[] args) {
        Comparable[] arr = {9, 10, 4, 5, 17, 25, 11, 6, 3, 9, 12};
        sort(arr);
        printArr(arr);
    }

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j - 1])) {
                    exch(arr, j, j - 1);
                }
            }
        }

    }

    /**
     * 判断a是否小于b
     * 
     * @param a
     * @param b
     * @return
     */
    public static boolean less(Comparable a, Comparable b) {
        if (a.compareTo(b) < 0) {
            return true;
        }
        return false;

    }

    /**
     * 将数组中i和j下标的数据互换位置
     * 
     * @param arr
     * @param i
     * @param j
     */
    public static void exch(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 校验排序已完成
     * 
     * @param arr
     * @return
     */
    public static boolean isSorted(Comparable[] arr) {

        return true;
    }

    public static void printArr(Comparable[] arr) {
        for (Comparable a : arr) {
            System.out.print(a + " ");
        }
    }



}
