package org.practice.cpdsa.array.important;

import org.practice.cpdsa.sorting.Helper;
//https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion1638/1
public class ConvertArrayZigZagFashion {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, 2};
        zigZag(arr, arr.length);
    }

    private static void zigZag(int[] arr, int length) {

        // in this odd should be maximum >= and <= if not then swap...
        for(int i = 0; i < length - 1; i++) {

            if(i % 2 == 0) {
                // here, if we are in even position making sure even should be less than odd if not swap it...
                if (arr[i] > arr[i + 1]) {
                    Helper.swap(arr, i, i + 1);
                }
            } else {
                // here, if we are in odd position making sure odd should be greater than even if not swap it...
                if (arr[i] < arr[i + 1]) {
                    Helper.swap(arr, i, i + 1);
                }
            }
        }

        Helper.print(arr);
    }
}
