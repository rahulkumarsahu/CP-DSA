package org.practice.cpdsa.heaps.application;

import org.practice.cpdsa.sorting.Helper;

import java.util.Collections;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/largest-derangement-sequence/
public class LargestDerangement {

    public static void main(String[] args) {

        int n = 6;
        int[] arr = { 56, 21, 42, 67, 23, 74 };
        printLargest(arr, n);
    }

    private static void printLargest(int[] arr, int n) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(Integer data : arr) {
            pq.add(data);
        }
        int i = 0;
        while (pq.size() > 1) {

            int data = pq.poll();

            if(data == arr[i]) {
                int temp = pq.poll();
                arr[i] = temp;
                arr[i + 1] = data;
                i += 2;
            } else {
                arr[i] = data;
                i++;
            }
        }

        if(n % 2 != 0) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }

        Helper.print(arr);
    }
}
