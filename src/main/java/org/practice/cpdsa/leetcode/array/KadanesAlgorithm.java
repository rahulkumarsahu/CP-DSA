package org.practice.cpdsa.leetcode.array;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,-2,-3,-2,-9};
        int output = maximumSum(arr, arr.length);
        System.out.println(output);
    }
    // Kadanes algorithm says basically when we have -ve sum then ignore that and if we have positive then keep on adding
    // and maintain the max output variable
    private static int maximumSum(int[] arr, int length) {
        int sum = 0;
        int output = Integer.MIN_VALUE;

        for(int i = 0; i < length; i++) {
            sum = sum + arr[i];
            if(output < sum) {
                output = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return output;
    }
}
