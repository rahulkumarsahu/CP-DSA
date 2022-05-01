package org.practice.cpdsa.binary_search.application;

//https://www.hackerrank.com/challenges/beautiful-triplets/problem
public class BeautifulArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 7, 8, 10};
        int diff = 3;
        int output = beautifulArray(arr, diff);
        System.out.println(output);

    }

    private static int beautifulArray(int[] arr, int diff) {
        int counter = 0;
         // here using concept of binary search and iterating over array and incrementing by diff
        // and using binary search to check it is exists or not.
        for (int data : arr) {
            if (binarySearch(arr, data + diff) && binarySearch(arr, data + diff * 2)) {
                counter++;
            }
        }

        return counter;
    }

    private static Boolean binarySearch(int[] sortedArray, int target) {
        // array index start from 0 and end index will be one less than length;
        int startIndex = 0;
        int endIndex = sortedArray.length - 1;
        // to find the mid-value
        int midIndex = startIndex + (endIndex - startIndex) / 2;

        // continue till startIndex is <= endIndex
        while (startIndex <= endIndex) {
            //found in a middle element
            if(sortedArray[midIndex] == target) {
                return true;
            } else if (sortedArray[midIndex] < target) {
                // if mid-element is < then increase min because it will be in right side
                startIndex = midIndex + 1;
            } else {
                // if mid-element is > then reduce max because it will be in left side
                endIndex = midIndex - 1;
            }

            midIndex = startIndex + (endIndex - startIndex) / 2;

        }

        return false;

    }
}
