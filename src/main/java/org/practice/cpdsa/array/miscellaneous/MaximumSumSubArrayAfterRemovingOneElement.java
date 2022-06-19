package org.practice.cpdsa.array.miscellaneous;

public class MaximumSumSubArrayAfterRemovingOneElement {

    public static void main(String[] args) {

        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = arr.length;

        System.out.print(maxSumSubArrayRemovingOneEle(arr, n));
    }

    private static Integer maxSumSubArrayRemovingOneEle(int[] arr, int n) {

        int[] preSum = new int[n];
        int[] postSum = new int[n];

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];
            sum = Math.max(sum, arr[i]);
            maxSum = Math.max(maxSum, sum);
            preSum[i] = sum;
        }
        sum = 0;
        maxSum = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            sum += arr[i];
            sum = Math.max(sum, arr[i]);
            maxSum = Math.max(maxSum, sum);
            postSum[i] = sum;
        }


        for(int i = 1; i < n - 1; i++) {
           maxSum = Math.max(maxSum, preSum[i - 1] + postSum[i + 1]);
        }

        return maxSum;
    }
}
