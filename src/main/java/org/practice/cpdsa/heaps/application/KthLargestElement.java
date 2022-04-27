package org.practice.cpdsa.heaps.application;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {

        int[] arr = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
        int k = 3;

        kthSmallestElement(arr, k);
        kthLargestElement(arr, k);
        kthSmallestElementUpdated(arr, k);
        kthLargestElementUpdated(arr, k);
    }

    private static void kthLargestElement(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(Integer data : arr) {
            queue.offer(data);
        }

        for(int i = 0; i < k; i++) {
            System.out.println(queue.poll());
        }
    }

    private static void kthSmallestElement(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(Integer data : arr) {
            queue.offer(data);
        }

        for(int i = 0; i < k; i++) {
            System.out.println(queue.poll());
        }
    }

    private static void kthLargestElementUpdated(int[] input, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int data : input) {
            queue.add(data);

            if (queue.size() > k) {
                queue.poll();
            }
        }
    }

    private static void kthSmallestElementUpdated(int[] input, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int data : input) {
            queue.add(data);

            if (queue.size() > k) {
                queue.poll();
            }
        }
    }
}
