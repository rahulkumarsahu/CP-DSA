package org.practice.cpdsa.array.miscellaneous;

public class MaximumSumSubArrayAfterRemovingOneSubArray {

    public static void main(String[] args) {
        int arr[] = { 7, 6, -1, -4, -5, 7, 1 };
        System.out.print(maximumSum(arr, arr.length));
    }

    private static Integer maximumSum(int[] arr, int n) {
        int[] preSum = new int[n];
        int[] postSum = new int[n];

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];
            sum = Math.max(sum, arr[i]);
            maxSum = Math.max(maxSum, sum);
            preSum[i] = maxSum;
        }
        sum = 0;
        maxSum = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            sum = Math.max(sum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, sum);
            postSum[i] = maxSum;
        }


        for(int i = 0; i < n - 1; i++) {
            maxSum = Math.max(maxSum, preSum[i] + postSum[i + 1]);
        }

        return maxSum;
    }
}
