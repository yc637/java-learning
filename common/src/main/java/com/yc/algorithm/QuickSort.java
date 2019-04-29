package com.yc.algorithm;

/**
 * 快速排序
 * 快速排序是目前在实践中非常高效的一种排序算法，它不是稳定的排序算法，平均时间复杂度为O(nlogn)，最差情况下复杂度为O(n^2)。
 * 它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * @author gs
 * @date 2018年08月14日 15:15:39
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 10, 4, 5, 17, 25, 11, 6, 3, 9, 12};
//        quickSort(arr, 0, arr.length-1);
        qSort(arr, 0, arr.length-1);
    }

    /**
     * 自己写的
     * @param arr
     * @param left 需要排序的部分起始下标
     * @param right 需要排序的部分结束下标
     */
    static void quickSort(int[] arr, int left, int right) {
        printArr(arr);
        System.out.println("left:"+left+" right:"+right);
        if (arr.length > 0) {
            int leftLength = 0;
            int rightLength = 0;
            // change表示需要交换位置的数据长度，用于一次排序后重新分配数组下标
            int change = 1;
            int seed = arr[left];
            for (int i = left+1; i < right + 1; i++) {
                if (arr[i] < seed) {
                    int temp = arr[i];
                    for (int j = 0; j < change; j++) {
                        arr[i - j] = arr[i - j - 1];
                    }
                    arr[i-change] = temp;
                    leftLength++;
                } else {
                    change++;
                    rightLength++;
                }
            }
            if (leftLength > 0) {
                quickSort(arr, left, left+leftLength-1);
            }
            if (rightLength > 0) {
                quickSort(arr, right-rightLength+1, right);
            }
        }
    }

    public static void qSort(int[] arr, int head, int tail) {
        printArr(arr);
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    static void printArr(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
