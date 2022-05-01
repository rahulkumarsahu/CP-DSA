package org.practice.cpdsa.heaps.application;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/maximum-distinct-elements-removing-k-elements/
public class MaximumDistinctElements {

    public static void main(String[] args) {
        int[] arr = {1,2,2,2};
        int n = arr.length;
        int k = 1;

        System.out.println("Maximum distinct elements = " +
                maxDistinctNum(arr, n, k));
    }


    /**
     * Input : arr[] = {5, 7, 5, 5, 1, 2, 2}, k = 3
     * Output : 4
     * Remove 2 occurrences of element 5 and
     * 1 occurrence of element 2.
     *
     * Input : arr[] = {1, 2, 3, 4, 5, 6, 7}, k = 5
     * Output : 2
     *
     * Input : arr[] = {1, 2, 2, 2}, k = 1
     * Output : 1
     */
    private static Integer maxDistinctNum(int[] arr, int n, int k) {

        Map<Integer, Integer> dataMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            dataMap.put(arr[i], dataMap.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) ->
                a.getValue().equals(b.getValue()) ? Integer.compare(a.getKey(), b.getKey()) : Integer.compare(a.getValue(), b.getValue())
        );

        for (Map.Entry<Integer, Integer> entry : dataMap.entrySet()) {
            queue.offer(entry);
        }

        int count = 0;

        while (!queue.isEmpty()) {

            Map.Entry<Integer, Integer> data = queue.poll();

            if(data.getValue() != null && data.getValue() == 1) {
                count++;
            } else if(data.getValue() != null && k > 0 && k - (data.getValue() - 1) >= 0) {
                count++;
                k -= (data.getValue() - 1);
            }
        }

        if(k >= 0 && count != 0) {
            return count - k;
        }

        return count;
    }

}
