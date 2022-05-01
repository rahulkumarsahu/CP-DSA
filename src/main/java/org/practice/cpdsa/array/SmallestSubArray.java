package org.practice.cpdsa.array;

public class SmallestSubArray {

    public static void main(String[] args) {

        int[] arr = new int[]{2,3,5,1,6,7};
        // here we have to find out the smallest sub array size possible which sum is >= target
        int output = getSmallestSubArray(arr, 6, 6);
        System.out.println(output);

    }

    public static int getSmallestSubArray(int[] arr, int target, int n) {

        int answer = n + 1;
        // sliding window pointers...
        int end = 0;
        int start = 0;
        // to track sum...
        int sum = 0;

        // loop through j pointer till it is less than the length
        while(end < n) {
            // if sum <= target and with corner condition then do sum and increment j++
            while(sum <= target && end < n) {
                sum += arr[end];
                end++;
            }
            // if we got sum > than the target then we have to capture window size
            // and remove previous value till when sum > target
            while(sum > target && start < n) {
                answer = Math.min(answer, end - start);
                sum -= arr[start];
                start++;
            }
        }
        return answer;
    }

}
