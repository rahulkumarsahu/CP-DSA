package org.practice.cpdsa.array.important;

import java.util.Arrays;

public class MinimumPlatformRequired {

    public static void main(String[] args) {

        int[] arrival = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] departure = new int[]{910, 1200, 1120, 1130, 1900, 2000};

        int output = minimumPlatformRequired(arrival, departure, arrival.length);

        System.out.println(output);


    }

    /**
     * move i and j pointer to understand the logic.....
     *        i
     * 0900 0940 0950 1100 1500 1800
     * 0910 1120 1130 1200 1900 2000
     *  j
     */

    private static int minimumPlatformRequired(int[] arrival, int[] departure, int length) {
        // why 1? because min 1 platform will be there
        int platform = 1;

        // corner cases if array is not sort use this or handle by if condition in line 30
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int arrivalIndex = 1;
        int departureIndex = 0;

       while (arrivalIndex < length) {

           if(arrival[arrivalIndex] <= departure[departureIndex]) {
               platform++;
           } else {
               departureIndex++;
           }
           arrivalIndex++;
       }

        return platform;
    }
}
