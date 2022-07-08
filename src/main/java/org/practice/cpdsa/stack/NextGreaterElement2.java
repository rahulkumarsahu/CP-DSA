package org.practice.cpdsa.stack;


public class NextGreaterElement2 {

    public static void main(String[] args) {
        nextGreaterElements(new int[]{20, 15, 10, 5});
    }
    // another approach is to take one array of double size and assign value like
    // 20 15 10 5 10 15 10 5 and find first greater from right side and print the output of first N element
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] = -1;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()){
                result[i] = nums[stack.peek()];
            }
            stack.add(i);
        }

        return result;
    }
}