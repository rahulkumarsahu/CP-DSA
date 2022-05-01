package org.practice.cpdsa.binary_search.application;

import java.util.Arrays;
import java.util.OptionalInt;

public class SPOJEKOProblem {

    public static void main(String[] args) {

        int[] nums = new int[]{4, 42, 40, 26, 46};
        int target = 20;
        int output = ekoProblem( nums, target);
        System.out.println("The output is :- " + output);

    }

    private static int ekoProblem(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = 0;
        OptionalInt maxValue = Arrays.stream(nums).max();
        if(maxValue.isPresent()) {
            endIndex = maxValue.getAsInt();
        }

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            int returnValue = isPossibleSolution(nums, midIndex);
            if(returnValue == target) {
                return midIndex;
            } else if(returnValue > target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return startIndex;
    }

    private static int isPossibleSolution(int[] nums, int midIndex) {

        int sum = 0;

        for(int data : nums) {
            if (data >= midIndex) {
                sum += (data - midIndex);
            }
        }
        return sum;
    }
}
