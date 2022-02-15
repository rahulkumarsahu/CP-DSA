package org.practice.cpdsa.leetcode.binary_search.application;

public class InfiniteBinarySortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int output = findIndex(arr);
        System.out.println(output);
    }

    public  static int findIndex(int[] arr) {

        int startIndex = 0;
        int endIndex = 1;

        while(arr[endIndex] != 1) {
            int temp = endIndex + 1;
            endIndex = endIndex + (endIndex - startIndex + 1) * 2;
            startIndex = temp;
        }

        return binarySearch(arr, startIndex, endIndex);

    }

    public static int binarySearch(int[] arr, int startIndex, int endIndex) {

        while(startIndex <= endIndex) {

            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if (arr[midIndex] == 1) {
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }

        return startIndex;
    }


}
