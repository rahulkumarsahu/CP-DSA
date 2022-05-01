package org.practice.cpdsa.binary_search.application;

public class MinimumDifference {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 10, 15};
        int target = 12;
        int output = findMinimumDifference(arr, target);
        System.out.println(output);
    }

    // so always keep in mind minimum difference will be exact in the position where target exist because it will be 0 at that point
    // if key does not exist then when binary search loop will break then startIndex and endIndex will be always the closest element present in array
    private static int findMinimumDifference(int[] sortedArray, int target) {
        // array index start from 0 and end index will be one less than length;
        int startIndex = 0;
        int endIndex = sortedArray.length - 1;
        // to find the mid-value
        int midIndex = startIndex + (endIndex - startIndex) / 2;

        // continue till startIndex is <= endIndex
        while (startIndex <= endIndex) {
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

            midIndex = startIndex + (endIndex - startIndex) / 2;

        }
        int startIndexDiff = Math.abs(sortedArray[startIndex] - target);
        int endIndexDiff = Math.abs(sortedArray[endIndex] - target);

        return startIndexDiff < endIndexDiff ? startIndex : endIndex;
    }
}
