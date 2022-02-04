package org.practice.cpdsa.searching;
// O(logN)
public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedArray = new int[]{ 1, 2, 3, 4, 5 };
        int numberToSearch = 5;
        int index = binarySearch(sortedArray, numberToSearch);
        System.out.println(index);
    }

    private static int binarySearch(int[] sortedArray, int target) {
        // array index start from 0 and end index will be one less than length;
        int startIndex = 0;
        int endIndex = sortedArray.length - 1;

        // continue till startIndex is <= endIndex
        while (startIndex <= endIndex) {
            // to find the mid-value
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            //found in a middle element
            if(sortedArray[midIndex] == target) {
                return midIndex;
            } else if (sortedArray[midIndex] < target) {
                // if mid-element is < then increase min because it will be in right side
                startIndex = midIndex + 1;
            } else {
                // if mid-element is > then reduce max because it will be in left side
                endIndex = midIndex - 1;
            }

        }

        return -1;

    }

}
