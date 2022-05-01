package org.practice.cpdsa.heaps.application;

import java.util.Collections;
import java.util.PriorityQueue;
//  O(n * log(n))
// Maximum difference between two subsets of m elements
// https://www.geeksforgeeks.org/difference-maximum-sum-minimum-sum-n-m-elementsin-review/
public class MaximumMinimumDifference {

    public static void main(String[] args) {

        int[] arr = { 5, 8, 11, 40, 15 };
        int n = arr.length;
        int m = 2;
        System.out.print(findDifference(arr, n, m));
    }

    /**
     * Input : arr[] = 1 2 3 4 5
     *             m = 4
     * Output : 4
     * The maximum four elements are 2, 3,
     * 4 and 5. The minimum four elements are
     * 1, 2, 3 and 4. The difference between
     * two sums is (2 + 3 + 4 + 5) - (1 + 2
     * + 3 + 4) = 4
     *
     * Input : arr[] = 5 8 11 40 15
     *            m = 2
     * Output : 42
     * The difference is (40 + 15) - (5  + 8)
     */
    private static Integer findDifference(int[] arr, int n, int m) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(Integer data : arr) {

            minHeap.offer(data);
            maxHeap.offer(data);

            if(minHeap.size() > m && maxHeap.size() > m) {
                minHeap.poll();
                maxHeap.poll();
            }
        }
        int d1 = 0;
        int d2 = 0;
        for(int i = 0; i < m; i++) {
            d1 += minHeap.remove();
            d2 += maxHeap.remove();
        }

        return d1 - d2;
    }
}
