package org.practice.cpdsa.stack;

import java.util.Stack;

public class Pattern132 {

    public static void main(String[] args) {
       boolean status =  pattern132Approach1(new int[]{});
       boolean result = pattern132Approach2(new int[]{});
       boolean output = pattern132Approach3(new int[]{});

       System.out.println(status + " " + result + " " + output);
    }

    private static boolean pattern132Approach1(int[] nums) {

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[k] > nums[i] && nums[j] > nums[k]) return true;
                }
            }
        }

        return false;
        }

    private static boolean pattern132Approach2(int[] nums) {

        int mine = nums[0];
        for(int j = 0; j < nums.length - 1; j++){
            for(int k = j + 1; k < nums.length; k++){
                if(nums[k] > mine && nums[j] > nums[k]) return true;
            }
                 mine = Math.min(mine, nums[j]);
        }

        return false;
    }

    private static boolean pattern132Approach3(int[] nums) {

        Stack<Integer> st = new Stack<>();

        int thirdElement = Integer.MIN_VALUE; //nums[k]

        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] < thirdElement) return true;
            while(!st.isEmpty() && st.peek() < nums[i]) {
                thirdElement = st.peek();
                st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}
