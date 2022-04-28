package org.practice.cpdsa.heaps.application;

import org.practice.cpdsa.sorting.Helper;

import java.util.PriorityQueue;
//https://www.geeksforgeeks.org/smallest-derangement-sequence/
public class SmallestDerangement {

    public static void main(String[] args) {
        generateDerangement(3);
    }

    /**
     * Input: 3
     * Output : 2 3 1
     * Explanation: The Sequence is 1 2 3.
     * Possible permutations are (1, 2, 3), (1, 3, 2),
     *           (2, 1, 3), (2, 3, 1), (3, 1, 2) (3, 2, 1).
     * Derangement's are (2, 3, 1), (3, 1, 2).
     * Smallest Derangement: (2, 3, 1)
     *
     * Input : 5
     * Output : 2 1 4 5 3.
     * Explanation: Out of all the permutations of
     * (1, 2, 3, 4, 5), (2, 1, 4, 5, 3) is the first derangement.
     * 1 2 3 4 5 -> 2 1 4 3 5 -> 2 1 4 5 3
     */
    private static void generateDerangement(int n) {
        //
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = new int[n];

        for(int i = 1; i <= n; i++) {
            pq.add(i);
        }

        int i = 0;
        while (pq.size() > 1) {
            int d1 = pq.poll();
            int d2 = pq.poll();

            arr[i] = d2;
            arr[i + 1] = d1;
            i += 2;
        }

        if(n % 2 != 0) {
            arr[i] = arr[i - 1];
            arr[i - 1] = n;
        }

        Helper.print(arr);
    }
}
