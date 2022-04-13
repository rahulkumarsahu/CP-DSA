package org.practice.cpdsa.leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapApplication {

    public static void main(String[] args) {
        KthSmallestElement(new int[]{}, 5);
        KthLargestElement(new int[]{}, 5);

        //PriorityQueue minHeap=new PriorityQueue();
        //PriorityQueue maxHeap=new PriorityQueue(5, new MyComparator());

    }

    private static void KthLargestElement(int[] input, int k) {

        // min heap
         PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

       // PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int data : input) {
            queue.add(data);

            if (queue.size() > k) {
                queue.poll();
            }
        }
    }

    private static void KthSmallestElement(int[] input, int k) {
        // min heap
       // PriorityQueue queue = new PriorityQueue(Collections.reverseOrder());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int data : input) {
            queue.add(data);

            if (queue.size() > k) {
                queue.poll();
            }
        }
    }
}





