package org.practice.cpdsa.leetcode.stack;

import java.util.Stack;

public class MaximumAreaHistogram {

    public static void main(String[] args) {
        int maximumArea = maximumAreaHistogram(new int[]{6, 2, 5, 4, 5, 1, 6});
        // input -> 6 2 5 4 5 1 6
        // nsr i -> 1 5 3 5 5 7 7 (because at 7 index it will be 0)
        // nlr i -> -1 -1 1 1 3 -1 5
        // width -> 1 5 1 3 1 7 1
        System.out.println(maximumArea);
    }

    // this method will be used to calculate the maximum area from histogram
    private static int maximumAreaHistogram(int[] nums) {
        // this method will be used to get the index of Next Smallest Element Right
        int[] nearestSmallestRightIndex = getNearestSmallestRightIndex(nums);
        // this method will be used to get the index of Next Smallest Element Left
        int[] nearestSmallestLeftIndex = getNearestSmallestLeftIndex(nums);
        // do right - left -  1 = width[]
        int[] width = getWidthArray(nearestSmallestRightIndex, nearestSmallestLeftIndex);
        // width[i] * arr[i]
        return getMaximumArea(nums, width);
    }

    private static int getMaximumArea(int[] nums, int[] width) {
        int maximumArea = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            maximumArea = Math.max(maximumArea, nums[i] * width[i]);
        }

        return maximumArea;
    }

    private static int[] getWidthArray(int[] nearestSmallestRightIndex, int[] nearestSmallestLeftIndex) {
        int length = nearestSmallestRightIndex.length;
        int[] width = new int[length];

        for(int i = 0; i < length; i++) {
            width[i] = nearestSmallestRightIndex[i] - nearestSmallestLeftIndex[i] - 1;
        }

        return width;
    }

    private static int[] getNearestSmallestLeftIndex(int[] nums) {
        int length = nums.length;
        Stack<Integer> indexStack = new Stack<>();
        int[] output = new int[length];

        for(int i = 0; i < length; i++) {
            if(indexStack.isEmpty()) {
                output[i] = -1;
            } else if(nums[indexStack.peek()] < nums[i]) {
                output[i] = indexStack.peek();
            } else if(!indexStack.isEmpty()) {
                while (!indexStack.isEmpty() && nums[indexStack.peek()] >= nums[i]) {
                    indexStack.pop();
                }
                if(indexStack.isEmpty()) {
                    output[i] = -1;
                } else {
                    output[i] = indexStack.peek();
                }
            }
            indexStack.push(i);
        }
        return output;
    }

    private static int[] getNearestSmallestRightIndex(int[] nums) {
        int length = nums.length;
        Stack<Integer> indexStack = new Stack<>();
        int[] output = new int[length];
        for(int i = length - 1; i >= 0; i--) {
            if(indexStack.isEmpty()) {
                output[i] = length;
            } else if(nums[indexStack.peek()] < nums[i]) {
                output[i] = indexStack.peek();
            } else if(!indexStack.isEmpty()) {
                while(!indexStack.isEmpty() && nums[indexStack.peek()] >= nums[i]) {
                    indexStack.pop();
                }
                if(indexStack.isEmpty()) {
                    output[i] = length;
                } else {
                    output[i] = indexStack.peek();
                }
            }
            indexStack.push(i);
        }

        return output;
    }
}
