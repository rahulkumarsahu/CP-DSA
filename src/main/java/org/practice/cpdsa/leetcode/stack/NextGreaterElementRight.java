package org.practice.cpdsa.leetcode.stack;

import org.practice.cpdsa.sorting.Helper;

import java.util.Stack;

public class NextGreaterElementRight {

    public static void main(String[] args) {
        int[] output = nextGreaterElements(new int[]{1,2,1});
        Helper.print(output);
    }

    public static int[] nextGreaterElements(int[] nums) {
        // data stack will be used to find the maximum from given array
        Stack<Integer> dataStack = new Stack<>();
        // length of given array
        int length = nums.length;
        // declaring the output length
        int[] arr = new int[length];
        // iterating from last the num array
        for (int i = length - 1; i >= 0; i--) {
            //  data stack will be empty initially and arr[length - 1] right side will have no value, so it will be -1
            if (dataStack.isEmpty()) {
                arr[i] = -1;
            } else if (dataStack.peek() > nums[i]) {
                // if data stack peek element is greater then we got right greater element
                arr[i] = dataStack.peek();
            } else if (!dataStack.isEmpty()) {
                // if peek element is lesser than the current element so popping out the data till we find greater element
                while (!dataStack.isEmpty() && dataStack.peek() <= nums[i]) {
                    dataStack.pop();
                }
                // if it is empty means we did not find maximum
                if (dataStack.isEmpty()) {
                    arr[i] = -1;
                } else {
                    // here we find the maximum
                    arr[i] = dataStack.peek();
                }
            }
            // pushing the data into stack nums[i]
            dataStack.push(nums[i]);
        }

        return arr;
    }
}
