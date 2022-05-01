package org.practice.cpdsa.company.google;

public class DecreasingSubsequences {

    public static void main(String[] args) {
        int[] input = new int[]{5, 2, 4, 3, 1, 6};
        //int output = findCountOfDecreasingSubsequence(input);
        int result = leastSubsequences(input);

        System.out.println(result);
    }
    // brute-force
    // loop 1
    // loop 2 get all possible combination which is less than current index value j = i + 1;

    public static int findCountOfDecreasingSubsequence(int[] input) {
        int count = 0;
        return count;
    }

    public static int leastSubsequences(int... nums) {
        int[] piles = new int[nums.length];
        int size = 0;
        for (int val : nums) {
            int pile = binarySearch(piles, 0, size, val);
            piles[pile] = val;
            if (pile == size) size++;
        }
        return size;
    }

    // find first element greater than target
    public static int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


}
