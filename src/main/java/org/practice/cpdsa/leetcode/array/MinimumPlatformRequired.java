package org.practice.cpdsa.leetcode.array;

import java.util.Arrays;

public class MinimumPlatformRequired {

    public static void main(String[] args) {

        int[] arrival = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] departure = new int[]{910, 1200, 1120, 1130, 1900, 2000};

        int output = minimumPlatformRequired(arrival, departure, arrival.length);

        System.out.println(output);


    }

    private static int minimumPlatformRequired(int[] arrival, int[] departure, int length) {
        // why 1? because min 1 platform will be there
        int result = 0;
        int platform;

        // corner cases if array is not sort use this or handle by if condition in line 30
        Arrays.sort(arrival);
        Arrays.sort(departure);

        for(int i = 0; i < length; i++) {
            platform = 1;
            for(int j = i + 1; j < length; j++) {
                // if arrival time is less than the departure time of previous than increment counter
                if(arrival[j] <= departure[i]) {
                    platform++;
                }
            }

            result = Math.max(result, platform);
        }

        return result;
    }
}
