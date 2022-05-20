package org.practice.cpdsa.array.important;

import org.practice.cpdsa.sorting.Helper;

// https://practice.geeksforgeeks.org/problems/unsorted-array4925/1
public class LeftSmallerAndRightGreaterElement {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 5, 7};
        findElement(arr, arr.length);
    }

    public static void findElement(int arr[], int n){

        // 4 4 5 7
        // 2 2 5 7
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            left[i] = max;
        }
        // 4 4 5 7
        Helper.print(left);

        for(int i = n - 1; i >= 0; i--) {
            min = Math.min(min, arr[i]);
            right[i] = min;
        }
        // 2 2 5 7
        Helper.print(right);

        for(int i = 1; i < n - 1; i++) {
            // 4, 2, 5, 7
            // 4, 4, 5, 7 -> left
            // 2, 2, 5, 7 -> right
            // if 2 >= 4 and 2 <= 5 ->  5 >= 4 and 5 <= 7 -> return 5;
            if(arr[i] >= left[i - 1] && arr[i] <= right[i + 1]) {
                System.out.println(arr[i]);
            }
        }

    }
}
