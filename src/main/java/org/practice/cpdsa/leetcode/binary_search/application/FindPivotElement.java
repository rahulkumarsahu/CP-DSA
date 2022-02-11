package org.practice.cpdsa.leetcode.binary_search.application;

public class FindPivotElement {

    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 7, 0, 1, 2, 3, 4};
        int pivotElement = findPivotElement(array);
        System.out.println("The Pivot Element index is :- " + pivotElement);
    }

    /**
     * here, from input we can figure out few points
     * we have two-part of increasing array one is 5,6,7 and 0,1,2,3,4, so we have to find 0 index value as output,
     * so we will calculate the mid-value first now we have to figure out in which part my mid-index is existed
     * if it is in second part then my pivot element will be mid or in left side of mid, end = mid;
     * if it is in first part then my pivot element will be in right side start = mid + 1
     * so to check the part of the array we can check this condition arr[mid] > arr[0]
     * if above condition is true that means it lying in first part
     * if mid-part is existed in second part then above condition will never be true because it is rotated sorted array
     * the arr[0] will always be greater than the second part of array.
     */
    public static int findPivotElement(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        // here we are iterating till < because when start become y and end become y which is already calculated will
        // become infinite so removing =
        while(startIndex < endIndex) {

            int midIndex = startIndex + (endIndex - startIndex) / 2;
            // checking last element and first element greater to find the right side to search
            // if issue comes remove nums[midIndex] >= nums[nums.length-1]
            if(nums[midIndex] >= nums[nums.length - 1] && nums[midIndex] >= nums[0]) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex;
            }
        }

        return startIndex;
    }
}
