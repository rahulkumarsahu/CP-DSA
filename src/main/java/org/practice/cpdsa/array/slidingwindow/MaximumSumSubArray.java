package org.practice.cpdsa.array.slidingwindow;

// https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3
//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
public class MaximumSumSubArray {

    public static void main(String[] args) {

        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        int target = 3;
        int output = maximumSumOfSubArray(arr, target, arr.length - 1);
        System.out.println(output);
    }

    private static int maximumSumOfSubArray(int[] arr, int target, int length) {

        int i  = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        while (j <= length) {

            sum += arr[j];

            if(j - i + 1 == target) {
                max = Math.max(max, sum);
            } else if(j - i + 1 > target) {
                while (j - i + 1 != target) {
                    sum -= arr[i];
                    i++;
                }
                max = Math.max(max, sum);
            }

            j++;
        }

        return max;
    }


    // fixed sliding window ->
    // 1. take two pointer i and j == 0 which  represent our window
    // 2. do calculation.
    // 3. if sliding window size is < given window size then increase j.
    // 4. if sliding window size == given window size then get the answer and remove the current i element
}
