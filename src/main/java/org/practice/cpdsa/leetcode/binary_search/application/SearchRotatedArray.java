package org.practice.cpdsa.leetcode.binary_search.application;

import static org.practice.cpdsa.leetcode.binary_search.application.FindPivotElement.findPivotElement;

public class SearchRotatedArray {

    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 7, 0, 1, 2, 3, 4};
        int target = 0;
        int searchElement = search(array, target);
        System.out.println("The search Element index is :- " + searchElement);
    }

    /**
     * To search in rotated array first we have to find PIVOT element in this example {5, 6, 7, 0, 1, 2, 3, 4} pivot element is 0
     * and after finding PIVOT element we can say that as array is sorted and rotated so searching element will be lying in between
     * pivot to endIndex or pivot to startIndex , so after that we can apply binary search easily.
     */
    private static int search(int[] nums, int target) {

        int pivotIndex = findPivotElement(nums);
        int startIndex = 0;
        int endIndex = nums.length - 1;

        if(target >= nums[pivotIndex] &&  target <= nums[nums.length - 1]) {
            startIndex = pivotIndex;
        } else {
            endIndex = pivotIndex - 1;
        }

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if(nums[midIndex] == target) {
                return midIndex;
            } else if(nums[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return -1;
    }

}
