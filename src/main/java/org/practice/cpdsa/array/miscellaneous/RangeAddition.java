package org.practice.cpdsa.array.miscellaneous;

import org.practice.cpdsa.sorting.Helper;

public class RangeAddition {

    public static void main(String[] args) {

        int length = 5;
        int[][] updates = new int[][]{{1,3,2},{2,4,3},{0,2,-2}};

        int[] output = getModifiedArray(length, updates);

        Helper.print(output);
    }

    /**
     * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
     * Output: [-2,0,3,5,3]
     *
     * Initial state:
     * [0,0,0,0,0]
     *
     * After applying operation [1,3,2]:
     * [0,2,2,2,0]
     *
     * After applying operation [2,4,3]:
     * [0,2,5,5,3]
     *
     * After applying operation [0,2,-2]:
     * [-2,0,3,5,3]
     *
     * Solution
     *  0 1 2 3 4
     *  0 0 0 0 0
     *  0 2 0 0 -2
     *  0 2 3 0 -2
     * -2 2 3 2 -2
     * -2 0 3 5 3
     */
    private static int[] getModifiedArray(int length, int[][] updates) {
        int[] data = new int[length];

        for(int[] query : updates) {

            int startIndex = query[0];
            int endIndex = query[1];
            int increment = query[2];

            data[startIndex] += increment;

            if(endIndex + 1 < length) {
                data[endIndex + 1] -= increment;
            }


        }

        for(int i = 1; i < data.length; i++) {
            data[i] += data[i - 1];
        }

        return data;
    }
}
