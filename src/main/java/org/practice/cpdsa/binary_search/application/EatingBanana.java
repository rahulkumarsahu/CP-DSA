package org.practice.cpdsa.binary_search.application;

import java.util.Arrays;

public class EatingBanana {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 7, 11};
        int hours = 8;
        System.out.println(getMinimumRate(arr, hours));
    }

    private static Integer getMinimumRate(int[] arr, int hours) {
        Arrays.sort(arr);
        int low = arr[0];
        int high = arr[arr.length - 1];
        int sum = Arrays.stream(arr).sum();

        while (low <= high) {

            int mid = (low + high) / 2;

            if(isPossibleSolution(hours, sum, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }

    private static boolean isPossibleSolution(int hours, int sum, int mid) {

        return hours * mid >= sum;
    }
}
