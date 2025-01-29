package org.practice.cpdsa.binary_search.application;

import java.util.Arrays;

public class EatingBanana {

    /**
     * 3     6      7      11
     * 8
     * low -> 1 , high -> 11 , mid -> 6
     * isPossible -> 6
     * 3 6 7 11
     * 1 1 2 2 -> 6h <= 8h possible solution return true;
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 7, 11};
        int hours = 8;
        System.out.println(getMinimumRate(arr, hours));
    }

    private static Integer getMinimumRate(int[] arr, int hours) {
        Arrays.sort(arr);
        int low = arr[0];
        int high = arr[arr.length - 1];

        while (low <= high) {

            int mid = (low + high) / 2;

            if(isPossibleSolution(arr, hours, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }

    /**
     * 3 6 7 11
     * 1 1 2 2 -> 6h <= 8h possible solution return true;
     */
    private static boolean isPossibleSolution(int[] arr, int hours, int mid) {
        // speed = 0;
        int speed = 0;

        for(int data : arr) {
            // if 3 / 6 , 6 / 6, ..... here if mid will be less than mid-element then speed becomes 0, and he will be able to eat in 1h -> so if we are getting 0 then checking condition and increasing speed
            //                         here if mid will be more than mid-element then speed becomes like 11 / 4 -> 2
            //                         here if mid will be equal to mid-element then speed becomes like 7/7 -> 1 so next if condition will break
            speed += data / mid; // ->

            if(data % mid != 0) speed++;
        }

        //if speed is less than the given h hours, We need to increase Speed,to increase speed we need to select lower value between low ---- > mid-1 as mid;
        return speed <= hours;
    }

    /**
     * for easy understanding solution
    private static boolean isPossibleSolutionUpdated(int[] arr, int hours, int mid) {

        int totalH = 0;

        for (int i = 0; i < arr.length; i++) {
            totalH += Math.ceil((double)(arr[i]) / (double)(hours));
        }

        //if speed is less than the given h hours, We need to increase Speed,to increase speed we need to select lower value between low ---- > mid-1 as mid;
        return totalH <= hours;
    }
     **/
}
