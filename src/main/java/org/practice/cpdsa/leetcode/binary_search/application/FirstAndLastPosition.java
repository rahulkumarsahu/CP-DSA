package org.practice.cpdsa.leetcode.binary_search.application;

public class FirstAndLastPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 9};
        int target = 8;
        int[] output = firstAndLastPosition( nums, target);
        System.out.println("The first and last index are :- " + output[0] + " , " + output[1]);
    }

    private static int[] firstAndLastPosition(int[] nums, int target) {

        int[] arr = new int[2];

        // To Find first occurrence
        arr[0] = firstOccurrence(nums, target);
        // To Find last occurrence
        arr[1] = lastOccurrence(nums, target);

        return arr;
    }

    public static int lastOccurrence(int[] nums, int target) {
        int ans = -1;

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while(startIndex <= endIndex) {

            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if(nums[midIndex] == target) {
                ans = midIndex;
                // here we are looking for last occurrence, and obviously we will find this  in right side of mid-value so updating
                startIndex = midIndex + 1;
            } else if(nums[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return ans;
    }

    public static int firstOccurrence(int[] nums, int target) {
        int ans = -1;

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while(startIndex <= endIndex) {

            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if(nums[midIndex] == target) {
                ans = midIndex;
                // here we are looking for first occurrence, and obviously we will find this  in left side of mid-value so updating
                endIndex = midIndex - 1;
            } else if(nums[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        return ans;
    }
}
