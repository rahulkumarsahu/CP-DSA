package org.practice.cpdsa.binary_search.application;

public class Heaters {

    /**
     * Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
     * 2. Every house can be warmed, as long as the house is within the heater's warm radius range.
     * 3. Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
     * 4. Notice that all the heaters follow your radius standard, and the warm radius will be the same.
     * Constraints
     * 1 <= houses.length, heaters.length <= 3 * 10^4
     * 1 <= houses[i], heaters[i] <= 10^9
     * Sample Input
     * 4
     * 1 2 5 7
     * 2
     * 1 4
     * Output
     * 1 2 5 7
     * 0 1 1 3
     * 1 4
     * 3
     */
    public static void main(String[] args) {

        int houseCount = 4;
        int heaterCount = 2;
        int[] house = new int[]{1, 2, 5, 7};
        int[] heater = new int[]{1, 4};

       System.out.println(getMaxRadiusOfHeater(house, houseCount, heater, heaterCount));
    }

    private static Integer getMaxRadiusOfHeater(int[] house, int houseCount, int[] heater, int heaterCount) {

        int maxRadius = 0;

        for(int i = 0; i < houseCount; i++) {
            int output = getNearestHeaterRadius(house[i], heater, heaterCount);
            maxRadius = Math.max(maxRadius, output);
        }

        return maxRadius;
    }

    private static int getNearestHeaterRadius(int data, int[] heater, int heaterCount) {
        int low = 0;
        int high = heaterCount - 1;
        int upper = 0;
        int lower = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(heater[mid] == data) {
                return 0;
            } else if(heater[mid] < data) {
                lower = mid;
                low = mid + 1;
            } else {
                upper = mid;
                high = mid - 1;
            }
        }

        return Math.min(Math.abs(data - heater[lower]), Math.abs(data - heater[upper]));
    }
}
