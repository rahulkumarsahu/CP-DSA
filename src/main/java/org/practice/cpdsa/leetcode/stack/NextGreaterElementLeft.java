package org.practice.cpdsa.leetcode.stack;

import org.practice.cpdsa.sorting.Helper;

import java.util.Stack;

public class NextGreaterElementLeft {

    public static void main(String[] args) {
        int[] output = nextGreaterElements(new int[]{1,2,1});
        Helper.print(output);
    }

    private static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> dataStack = new Stack<>();
        int length = nums.length;
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            if (dataStack.isEmpty()) {
                arr[i] = -1;
            } else if (dataStack.peek() > nums[i]) {
                arr[i] = dataStack.peek();
            } else if (!dataStack.isEmpty()) {
                while(!dataStack.isEmpty() && dataStack.peek() <= nums[i]) {
                    dataStack.pop();
                }
                if(dataStack.isEmpty()) {
                    arr[i] = -1;
                } else {
                    arr[i] = dataStack.peek();
                }
            }
            dataStack.push(nums[i]);
        }

        return arr;
    }
}
