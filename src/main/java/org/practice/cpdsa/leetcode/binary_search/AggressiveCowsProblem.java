package org.practice.cpdsa.leetcode.binary_search;

import java.util.Arrays;
import java.util.OptionalInt;

public class AggressiveCowsProblem {

    public static void main(String[] args) {

        int[] arr = new int[]{0, 3, 4, 7, 10, 9};
        int numberOfCows = 3;
        int output = aggressiveCows(arr, numberOfCows);
        System.out.println("The Output is :- " + output);
    }

    private static int aggressiveCows(int[] arr, int numberOfCows) {
        // this is min value of search space
        int startIndex = 0;
        // this is max value of search space, and it will be max - min 0 value from array
        OptionalInt maxValue = Arrays.stream(arr).max();
        int endIndex =  -1;
        if(maxValue.isPresent()) {
            endIndex = maxValue.getAsInt();
        }
        // output
        int output = -1;

        while(startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            // if it is a possible solution then for finding longest we will go right side
            // because there is a chance we will find minimum distance as large as possible
            if(isPossibleSolution(arr, midIndex, numberOfCows)) {
                output = midIndex;
                startIndex = midIndex + 1;
            } else {
                // if this is not a possible solution then that right side element will also not be possible solution
                // so moving left side to find solution
                endIndex = midIndex - 1;
            }
        }

        return output;
    }

    private static boolean isPossibleSolution(int[] arr, int midIndex, int numberOfCows) {
        int startPoint = arr[0];
        int counter = 1;
        for(int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i] - startPoint) >= midIndex) {
                        counter++;
                        startPoint = arr[i];
            }
            if(counter == numberOfCows) return true;
        }

        return false;
    }

}
