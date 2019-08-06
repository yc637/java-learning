package com.yc.array;

/**
 * 一个大的数组，用多线程求和
 *
 * TODO未完成
 *
 * @author gs
 * @date 2019年08月02日 18:18:12
 */
public class ArraySum {

    public static void main(String[] args) {

        Integer[] arr = {9121, 12122, 33, 43, 4345, 4, 546, 4576, 68, 76, 88, 9, 7698, 456, 456, 3434, 5, 2345, 23, 66865, 8, 567, 45};
        int splitCount = 10;
        int singleArrLength = arr.length / splitCount;

        for (int i = 0; i < splitCount; i++) {
            try {
                Thread t = new Thread(new TestSum(arr, i * splitCount, i * (splitCount + 1)));
                t.start();
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class TestSum implements Runnable {
        @Override
        public void run() {
            int result = 0;
            for (int i  = 0; i < arr.length; i++) {
                result += arr[i];
            }
        }

        private int begin;
        private int end;
        private Integer[] arr;

        public TestSum(Integer[] arr, int begin, int end) {
            this.arr = arr;
            this.begin = begin;
            this.end = end;
        }
    }


}
