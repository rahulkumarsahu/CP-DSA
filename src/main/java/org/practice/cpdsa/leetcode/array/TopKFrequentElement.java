package org.practice.cpdsa.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class TopKFrequentElement {

    public static void main(String[] args) {

        int k = 2;
        getTopKFrequentElement(new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9}, k);
    }

    private static void getTopKFrequentElement(int[] arr, int k) {

        Map<Integer, Integer> dataMap = new HashMap<>();

        // store all the data frequency in the map...
        for (Integer value : arr) {
            dataMap.put(value, dataMap.getOrDefault(value, 0) + 1);
        }

        // pass the compare logic in the constructor of the priority queue
        // here in constructor we are checking if the frequency is equals then sort by the key else sort by the value(frequency)
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) ->
            a.getValue().equals(b.getValue()) ? Integer.compare(b.getKey(), a.getKey()) :
                    Integer.compare(b.getValue(), a.getValue()));

        for (Map.Entry<Integer, Integer> entry : dataMap.entrySet()) {
            queue.offer(entry);
        }

        for (int i = 0; i < k; i++) {
            System.out.println(Objects.requireNonNull(queue.poll()).getKey());
        }

    }
}
