package org.practice.cpdsa.stack;

import org.practice.cpdsa.sorting.Helper;

import java.util.Stack;

public class NextSmallerElementLeft {

    public static void main(String[] args) {
        int[] output = stockAndSpan(new int[]{100, 80, 60, 70, 60, 75, 85});
        Helper.print(output);
    }
    // stock and span works on concept of Next Greater Element Left side,
    // and we have to print counter how much value greater than left side
    // example 100, 80, 60, 70, 60, 75, 85
    //          1, 1, 1, 2, 1, 4, 6,
    // so we have to store index in dataStack and to get the counter
    // output = i - index
    public static int[] stockAndSpan(int[] nums) {

        Stack<Integer> dataStack = new Stack<>();
        int length = nums.length;
        int[] arr = new int[length];
        int[] output = new int[length];

        for (int i = 0; i < length; i++) {
            if (dataStack.isEmpty()) {
                arr[i] = -1;
            } else if (nums[dataStack.peek()] > nums[i]) {
                arr[i] = dataStack.peek();
            } else if (!dataStack.isEmpty()) {
                while(!dataStack.isEmpty() && nums[dataStack.peek()] <= nums[i]) {
                    dataStack.pop();
                }
                if(dataStack.isEmpty()) {
                    arr[i] = -1;
                } else {
                    arr[i] = dataStack.peek();
                }
            }
            dataStack.push(i);
        }

        for(int i = 0; i < arr.length; i++) {
            output[i] = i - arr[i];
        }
        return output;
    }

}
