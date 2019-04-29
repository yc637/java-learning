package com.yc.algorithm;

/**
 * 冒泡排序 从第一个数字开始，将相邻的数字两两比较，将大的和小的交换位置。
 * 例如：对数组{9, 12, 11, 0, 39, 4, 7, 1, 33, 26}进行排序
 * 第一步：9和12比较，9小于12，所以不交换
 * 第二步：12和11比较，12大于11，所以交换，交换后数组变成{9, 11, 12, 0, 39, 4, 7, 1, 33, 26}
 * 第三步：12和0比较，12大于0，交换后数组变成{9, 11, 0, 12, 39, 4, 7, 1, 33, 26}
 * 以此类推第一次遍历结束后，最大的数字一定会排在最后
 * 接着对除最后一位以外的数字继续进行冒泡排序，以此类推
 *
 * @author gs
 * @date 2018年08月14日 14:14:48
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {9, 12, 11, 0, 39, 4, 7, 1, 33, 26};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    static void sort(int[] arr) {
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 1; j < arr.length - i; j++) {
                    if (arr[j - 1] > arr[j]) {
                        swap(arr, j);
                    }
                }
            }
        }
    }

    private static void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
    }
}
