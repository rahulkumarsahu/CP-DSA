package org.practice.cpdsa.heaps.application;

import java.util.Collections;
import java.util.PriorityQueue;

public class KMaximumSum {

    public static void main(String[] args) {
        int[] arr1 = { 4, 2, 5, 1 };
        int[] arr2 = { 8, 0, 5, 3 };
        int n = arr1.length;
        int k = 3;

        // Function Call
        KMaxCombinations(arr1, arr2, n, k);
    }

    private static void KMaxCombinations(int[] a, int[] b, int n, int k) {

        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());

    }
}
