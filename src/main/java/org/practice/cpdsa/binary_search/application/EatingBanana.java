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

    private static boolean isPossibleSolution(int[] arr, int hours, int mid) {

        int speed = 0;

        for(int i : arr){
            speed += i / mid;
            if(i % mid != 0) speed++;
        }

        //if speed is less than the given h hours, We need to increase Speed,to increase speed we need to select lower value between low ---- > mid-1 as mid;
        return speed <= hours;
    }
}
