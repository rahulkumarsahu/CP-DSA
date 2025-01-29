package org.practice.cpdsa.array.basic;

// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/?envType=problem-list-v2&envId=array

import java.util.Scanner;

public class SumOfOddLengthSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 11, 12};
        int output = sumOddLengthSubArrays(arr);
        System.out.println(output);
    }
    // let's take input array [1, 2, 3]
    // outer loop will act as starting index of the sub array
    // inner loop will act as ending index of the sub array
    // [1] [1, 2] [1, 2, 3]
    // [2] [2, 3]
    // [3]
    public static int sumOddLengthSubArrays(int[] arr) {
        int sum = 0;
        int length = arr.length;

        for (int start = 0; start < length; start++) {
            for (int end = start; end < length; end++) {
                if ((end - start + 1) % 2 != 0) {
                    for (int k = start; k <= end; k++) {
                        sum += arr[k];
                    }
                }
            }
        }

        return sum;
    }
}
