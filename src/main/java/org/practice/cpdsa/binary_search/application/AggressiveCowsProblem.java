package org.practice.cpdsa.binary_search.application;

import java.util.Arrays;

public class AggressiveCowsProblem {

    public static void main(String[] args) {

        int[] arr = new int[]{4,2,1,3,6};
        int numberOfCows = 2;
        int output = aggressiveCows(arr, numberOfCows);
        System.out.println("The Output is :- " + output);
    }

    private static int aggressiveCows(int[] arr, int numberOfCows) {
        Arrays.sort(arr);
        // this is min value of search space
        int startIndex = 0;
        int endIndex =  arr[arr.length - 1];

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
        // here starting point will be 0 always
        int startPoint = arr[0];
        // maintain counter to check number of cows assigned
        int counter = 1;
        for(int i = 1; i < arr.length; i++) {
            // considering midIndex as max distance
            // if diff of arr[i] - start point >= midIndex that means we got one position for cow for considered maximum distance as midIndex
            // once we got distance C2 got placed then we will search place for C3, so we have to update the start point to C2 position
            // and after that if we find the position for C3 also it's a possible solution else return false
            if(Math.abs(arr[i] - startPoint) >= midIndex) {
                        counter++;
                        startPoint = arr[i];
            }
            if(counter == numberOfCows) return true;
        }

        return false;
    }

}
