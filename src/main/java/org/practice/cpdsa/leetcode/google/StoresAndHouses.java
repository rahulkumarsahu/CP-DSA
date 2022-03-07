package org.practice.cpdsa.leetcode.google;

import org.practice.cpdsa.sorting.Helper;

import java.util.Arrays;

public class StoresAndHouses {

    public static void main(String[] args) {
        // houses = [5, 10, 17]  stores = [1, 5, 20, 11, 16]
        // Output: [5, 11, 16]
        // Explanation:
        //        The closest store to the house at location 5 is the store at the same location.
        //        The closest store to the house at location 10 is the store at the location 11.
        //        The closest store to the house at location 17 is the store at the location 16.

        int[] house = new int[]{4, 8, 1, 1};
        int[] stores = new int[]{5, 3, 1, 2, 6};

        int[] output = findNearestHouse(house, stores);
        Helper.print(output);

    }

    private static int[] findNearestHouse(int[] house, int[] stores) {
        int length = house.length;
        int[] output = new int[length];
        Arrays.sort(stores);
        for(int i = 0; i < length; i++) {
            output[i] = getNearestHouse(house[i], stores);
        }

        return output;
    }

    private static int getNearestHouse(int target, int[] stores) {
        int startIndex = 0;
        int endIndex = stores.length - 1;
        int a1;
        int a2;

        if(target >= stores[endIndex]) {
            return stores[endIndex];
        }

        while(startIndex <= endIndex) {

            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if(stores[midIndex] == target) {
                return stores[midIndex];
            } else if(stores[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        a1 = Math.abs(stores[startIndex] - target);
        a2 = Math.abs(stores[endIndex] - target);

        if(a1 < a2) {
            return stores[startIndex];
        } else {
            return stores[endIndex];
        }
    }
}
