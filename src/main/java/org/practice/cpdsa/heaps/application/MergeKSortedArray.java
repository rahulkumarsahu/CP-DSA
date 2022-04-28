package org.practice.cpdsa.heaps.application;

import java.util.PriorityQueue;

public class MergeKSortedArray {

    public static void main(String[] args) {

        int[][] arr= {{2, 6, 12, 34}, {1, 9, 20, 1000}, {23, 34, 90, 2000}};

        mergeKSortedArrays(arr, arr.length);
    }

    private static void mergeKSortedArrays(int[][] arr, int length) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                pq.add(arr[i][j]);
            }
        }

        while (!pq.isEmpty()) {
            System.out.print(" " + pq.poll() + " ");
        }
    }
}
