package org.practice.cpdsa.leetcode.array;

public class SmallestSubArray {

    public static void main(String[] args) {

        int[] arr = new int[]{2,3,5,1,6,7};
        int output = getSmallestSubArray(arr, 6, 6);
        System.out.println(output);

    }

    public static int getSmallestSubArray(int[] arr, int target, int n) {

        int answer = n + 1;
        int end = 0;
        int start = 0;
        int sum = 0;
        while(end < n) {

            while(sum <= target && end < n) {
                sum += arr[end];
                end++;
            }
            while(sum > target && start < n) {
                answer = Math.min(answer, end - start);
                sum -= arr[start];
                start++;
            }
        }
        return answer;
    }

}
