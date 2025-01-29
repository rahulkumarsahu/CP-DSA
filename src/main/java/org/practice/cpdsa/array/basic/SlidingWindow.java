package org.practice.cpdsa.array.basic;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,1,1,1};

        int result = getTheMaximumLengthOfSubArray(arr, arr.length, 3);
        System.out.println(result);
    }

    // time complexity :- O(2 * N)
    private static int getTheMaximumLengthOfSubArray(int[] arr, int len, int k) {

        int i = 0;
        int j = 0;

        int maxWindow = 0;
        int sum = 0;

        while(j < len) {

            sum += arr[j];

            if (sum == k) {
                maxWindow = Math.max(maxWindow, j - i + 1);
            } else {
                while (sum > k) {
                    sum -= arr[i];
                    i++;
                }
                if (sum == k) {
                    maxWindow = Math.max(maxWindow, j - i + 1);
                }
            }

            j++;
        }

        return maxWindow;
    }
}

