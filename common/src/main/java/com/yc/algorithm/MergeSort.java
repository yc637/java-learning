package com.yc.algorithm;

/**
 * 归并排序
 *
 * @author gs
 * @date 2018年08月20日 16:16:57
 */
public class MergeSort {

    public static void main(String[] args) {
        Comparable[] arr = {10, 9, 4, 5, 3, 8, 7, 11, 6, 9, 3};
        Comparable[] newArr = new Comparable[arr.length];
//        merge(arr, 0, arr.length - 1, newArr);

//        add(arr, 2, 3, 4, 5);
        printArr(newArr);
    }

    public static void merge(Comparable[] arr, int start, int end, Comparable[] newArr) {
        printArr(arr);
        System.out.println(" start =  " + start + " end =  " + end);
        int length = end - start + 1;
        int left = length / 2;
        int right = length % 2 > 0 ? length / 2 + 1 : length / 2;
        System.out.println(length + " = " + left + " + " + right);
        if (left > 2) {
            merge(arr, start, start + left - 1, null);
        } else {
            swap(arr, start, start + left - 1);
        }
        if (right > 2) {
            merge(arr, end - right + 1, end, null);
        } else {
            swap(arr, end - right + 1, end);
        }
    }

//    private static void add(Comparable[] arr, int leftStart, int leftEnd, int rightStart, int rightEnd) {
//        int length = (leftEnd - leftStart + 1) + (rightEnd - rightStart + 1);
//        int newStart = leftStart;
//        for (int i = 0; i < length; i++) {
//            if (leftStart < leftEnd) {
//                if (arr[leftStart].compareTo(arr[rightStart]) < 0) {
//                    newArr[newStart+i] = arr[leftStart];
//                    leftStart++;
//                }
//            } else {
//                newArr[newStart+i] = arr[rightStart];
//                rightStart++;
//            }
//
//            if (rightStart < rightEnd) {
//                if(arr[leftStart].compareTo(arr[rightStart]) >= 0) {
//                    newArr[newStart+i] = arr[rightStart];
//                    rightStart++;
//                }
//            } else {
//                newArr[newStart+i] = arr[leftStart];
//                leftStart++;
//            }
//
//        }
//    }

    public static void swap(Comparable[] arr, int start, int end) {
        if (arr[start].compareTo(arr[end]) > 0) {
            Comparable temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public static void printArr(Comparable[] arr) {
        for (Comparable a : arr) {
            System.out.print(a + " ");
        }
    }
}
