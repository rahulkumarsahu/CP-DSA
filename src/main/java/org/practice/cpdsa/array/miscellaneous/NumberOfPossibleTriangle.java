package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;

public class NumberOfPossibleTriangle {

    public static int findNumberOfTriangles(int[] arr, int n) {

        Arrays.sort(arr);

        int count = 0;

        for(int i = arr.length - 1; i >= 2; i--) {

            int l = 0;
            int r = i - 1;

            while(l < r) {

                if(arr[l] + arr[r] > arr[i]) {
                    count += (r - l);
                    r--;
                } else {
                    l++;
                }
            }
        }

        return count;

    }
}
