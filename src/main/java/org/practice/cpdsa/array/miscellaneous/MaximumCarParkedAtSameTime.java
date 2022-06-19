package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumCarParkedAtSameTime {

    public static void main(String[] args) {
        int[][] arr = {{ 1012, 1136 }, { 1317, 1412 }, { 1015, 1020 }};

        // Size of the array
        int N = arr.length;

        // Function Call
        System.out.println(maxCars(arr, N));
    }

    private static Integer maxCars(int[][] arr, int n) {

        Pair[] pair = new Pair[2 * n];

        for(int i = 0; i < n; i++) {
            pair[2 * i] = new Pair(arr[i][0], true);
            pair[2 * i + 1] = new Pair(arr[i][1], false);
        }

        Arrays.sort(pair, Comparator.comparingInt(a -> a.interval));

        int count = 0;
        int maxCount = Integer.MIN_VALUE;

        for(int i = 0; i < pair.length; i++) {

            if(pair[i].status) {
                count++;
            } else {
                maxCount = Math.max(count, maxCount);
                count--;
            }
        }

        return maxCount;

    }
}
 class Pair {

    public int interval;
    public boolean status;

    public Pair(int interval, boolean status) {
        this.interval = interval;
        this.status = status;
    }

}
