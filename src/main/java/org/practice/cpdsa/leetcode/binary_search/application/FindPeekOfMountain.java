package org.practice.cpdsa.leetcode.binary_search.application;

public class FindPeekOfMountain {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 7, 8, 9, 3, 2, 1};
        int peekOfMountain = findPeekOfMountain(arr);
        System.out.println("The Peek of Mountain index is :- " + peekOfMountain);
    }

    /**
     * From the input we can easily figure out few points
     * the array has two parts one is increasing 5,6,7,8,9 and another array is decreasing 3,2,1
     * first one follows arr[mid] < arr[mid+1] and second one follows arr[mid] > arr[mid+1]
     * so we have to find peak or max element, so obviously we have to figure out increasing part and search on that
     * so to find increasing part we will use 1st condition arr[mid] < arr[mid+1]
     * if it satisfies then we are on increasing part of array, so to find maximum we will just do start = mid + 1; we will move towards right
     * if mid-point lying between decreasing part, so we have to move our end Index = midIndex we will move towards left side
     * because it can be peak element or decreasing part of array
     */
    private static int findPeekOfMountain(int[] nums) {

        int startIndex = 0;
        int endIndex = nums.length - 1;
        // here we are iterating till < because when start become y and end become y which is already calculated will
        // become infinite so removing =
        while(startIndex < endIndex) {

            int midIndex = startIndex + (endIndex - startIndex) / 2;
            // here checking < with mid to mid = 1 to find the peek of mountain
            if(nums[midIndex] < nums[midIndex + 1]) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex;
            }
        }

        return startIndex;
    }
}
