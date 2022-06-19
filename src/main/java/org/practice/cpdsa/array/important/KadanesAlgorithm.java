package org.practice.cpdsa.array.important;

public class KadanesAlgorithm {

    public static void main(String[] args) {

        System.out.println('a' + 'b');
        int[] arr = new int[]{-1, -2, -3, -2, -9};
        int output = maximumSum(arr, arr.length);
        int result = maxSubArray(new int[]{2, -3, 8, -2, 5});
        System.out.println(result);
        System.out.println(output);
    }
    // Kadane's algorithm says basically when we have -ve sum or sum < 0 then make sum = 0 and update result whenever we have output < sum update result
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

    public static int maxSubArray(int[] nums) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        int l = 0;
        int r = 0;
        int beg = 0;

        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if(sum < nums[i]) {
                beg = i;
                sum = nums[i];
            }

            if(sum > max) {
                max = sum;
                r = i;
                l = beg;
            }

        }

        System.out.println(" start = " + l + " end = " + r);

        int maximum = Integer.MIN_VALUE;
        for(int i = l; i <= r; i++) {
           maximum =  Math.max(maximum, nums[i]);
        }

        return max * maximum;

      //  return max;

    }
}
