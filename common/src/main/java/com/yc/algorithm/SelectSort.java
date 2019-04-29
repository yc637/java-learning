package com.yc.algorithm;

/**
 * 选择排序
 * <p>
 * 选择最大（最小）数，放在数组末尾（开头）
 * 继续在剩余数字中选择最大的数，与第一个数依次排列，直到整个数组变为有序
 *
 * @author gs
 * @date 2018年08月15日 14:14:40
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {9, 10, 4, 5, 17, 25, 7, 11, 6, 3, 9, 12};
//        selectSort(arr);
        select_sort(arr);
    }

    /**
     * 自己实现
     *
     * @param arr
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            printArr(arr);
            int n = 0;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[n] < arr[j]) {
                    n = j;
                }
            }
            int temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[n];
            arr[n] = temp;
        }
    }

    /**
     * 网上的实现
     *
     * @param arr
     */
    static void select_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            printArr(arr);
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
