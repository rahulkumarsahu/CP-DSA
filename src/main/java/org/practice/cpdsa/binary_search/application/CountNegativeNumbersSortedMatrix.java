package org.practice.cpdsa.binary_search.application;

public class CountNegativeNumbersSortedMatrix {

    public static void main(String[] args) {
        countNegatives(new int[][]{});
    }

    public static int countNegatives(int[][] grid) {

        int count = 0;
        for (int[] arr : grid) {
            count += getCount(arr);
        }

        return count;
    }

    public static int getCount(int[] arr) {

        int i = 0;
        int j = arr.length - 1;
        int mid = 0;

        while( i < j) {

            mid = i + (j - i) / 2;
            if(arr[mid] < 0) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return arr.length - mid + 1;

    }
}
