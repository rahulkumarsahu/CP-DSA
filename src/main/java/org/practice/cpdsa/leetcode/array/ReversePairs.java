package org.practice.cpdsa.leetcode.array;

import java.util.Arrays;

public class ReversePairs {


    public static void main(String[] args) {

        int[] arr = new int[]{1, 9, 6, 4, 5};
        int[] temp = Arrays.copyOf(arr, arr.length);
        int output = mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println(output);

    }

    private static int mergeSort(int[] arr, int[] temp, int startIndex, int endIndex) {

        if(endIndex <= startIndex) return 0;

        int midIndex = startIndex + (endIndex - startIndex) / 2;

        int count = 0;

        count += mergeSort(arr, temp, startIndex, midIndex);
        count += mergeSort(arr, temp, midIndex + 1, endIndex);

        count += merge(arr, temp, startIndex, midIndex, endIndex);

        return count;

    }
    // https://www.youtube.com/watch?v=S6rsAlj_iB4
    private static int merge(int[] arr, int[] temp, int startIndex, int midIndex, int endIndex) {

        int count = 0;

        int i = startIndex;
        int j = midIndex + 1;
        int n = j;
        int k = startIndex;

        //why??
        //
        for(int m = startIndex; m <= midIndex; m++) {

            while (n <= endIndex && arr[m] > 2 * arr[n]) {
                n++;
            }

            count += (j - (midIndex + 1));

        }

        while(i <= midIndex && j <= endIndex) {
            if(arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= midIndex) {
            temp[k++] = arr[i++];
        }

        for(i = startIndex; i <= endIndex; i++) {
            arr[i] = temp[i];
        }

        return count;
    }

}
