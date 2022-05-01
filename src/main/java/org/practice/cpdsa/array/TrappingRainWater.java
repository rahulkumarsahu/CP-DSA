package org.practice.cpdsa.array;

public class TrappingRainWater {

    public static void main(String[] args) {
        int output = trappingRainWater(new int[]{3,1,2,4,0,1,3,2});
        System.out.println(output);

    }

    public static int trappingRainWater(int[] arr) {
        int length = arr.length;
        // To store left max from the array
        int[] left = new int[length];
        // To store the right max from the array
        int[] right = new int[length];
        // store first value as maximum
        left[0] = arr[0];
        // store second value as maximum
        right[length - 1] = arr[length - 1];
        // To find max till the end of array from left side
        for(int i = 1; i < length; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        // To find the max from the right of array from right side
        for(int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        int ans = 0;
        // here finding minimum from left side max and right side max at particular index
        // and subtract the current index value to get the water
        for(int i = 0; i < length; i++) {
            ans += (Math.min(left[i], right[i]) - arr[i]);
        }

        return ans;
    }
}
