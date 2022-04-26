package org.practice.cpdsa.leetcode.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class IncreasingDecreasingArray {

    public static void main(String[] args) {

        int output = getMinimumCountToMakeArrayIncreasing(new int[]{});
        int result = getMinimumCountToMakeArrayDecreasing(new int[]{});
        System.out.println(output);
        System.out.println(result);
    }

    private static int getMinimumCountToMakeArrayDecreasing(int[] arr) {

        int steps = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {

            if(!pq.isEmpty() && pq.peek() < arr[i]) {

                steps += arr[i] - pq.peek();
                pq.add(arr[i]);
                pq.poll();
            }

            pq.add(arr[i]);
        }

        return steps;
    }

    private static int getMinimumCountToMakeArrayIncreasing(int[] arr) {

        int steps = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++) {
            // check pq is empty or not and if top element is > current element
            // that means we have to do some operation to make the array strictly increasing...
            if(!pq.isEmpty() && pq.peek() >= arr[i]) {
                // backup of old value....
                int oldValue = arr[i];
                // updating the current element to make increasing just previous value + 1 means peek element + 1
                arr[i] = pq.peek() + 1;
                // to find the steps
                steps += pq.peek() - oldValue;
                // add the element
                pq.add(arr[i]);
                // remove the top element
                pq.poll();
            }

            pq.add(arr[i]);
        }

        return steps;
    }
}
