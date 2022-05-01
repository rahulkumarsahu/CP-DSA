package org.practice.cpdsa.company.google;

import java.util.Arrays;
import java.util.OptionalInt;

public class MinDaysToBloom {

    public static void main(String[] args) {
        // days in which day flower will bloom
        int[] flowers = new int[]{1, 2, 4, 9, 3, 4, 1};
        // k is adjacent flower count
        int k = 2;
        //number of bucket we have to form
        int m = 2;

        int output = minDaysToBloom(flowers, m, k);

        System.out.println(output);
    }

    private static int minDaysToBloom(int[] flowers, int m, int k) {

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        // if m * k is less than the length then there is no possibility of creating m bucket of flower
        if(flowers.length < m * k) return -1;

        // flower contains number of days so max possible number of days is maxValue from array
        OptionalInt maxValue = Arrays.stream(flowers).max();
        if(maxValue.isPresent()) {
            max = maxValue.getAsInt();
        }
        // flower contains number of days so min possible number of days is minValue from array
        OptionalInt minValue = Arrays.stream(flowers).min();
        if(minValue.isPresent()) {
            min = minValue.getAsInt();
        }

        // iterating over number of days to get min number of days and will check like
        // max possible days can be the answer or min possible days can be the answer
        // so to find the answer we are depending on days and checking by using binary search which can be the possible number of min days
        while(min < max) {
            int mid = min + (max - min) / 2;
            int answer = isPossibleAnswer(flowers, mid, k);
            // if we did not get our answer on first part like from min to mid, so we will not get our answer so move to mid + 1
            if(answer < m) {
                min = mid + 1;
            } else {
                // if we get our answer on first part then move max to mid-element
                max = mid;
            }
        }
        return min;
    }

    private static int isPossibleAnswer(int[] flowers, int expectedDay, int k) {
         int bucket = 0;
         int flowerCollected = 0;

         for(int value : flowers) {
             // current value which is bloom day from flower array is less than expected day then we can increase flower collected
             if(value <= expectedDay) {
                 flowerCollected++;
             } else {
                 // making flower collected to 0 to maintain adjacent flower to create bucket
                 flowerCollected = 0;
             }
             // here we find
             if(flowerCollected == k) {
                 bucket++;
                 flowerCollected = 0;
             }
         }

         return bucket;
    }
}
