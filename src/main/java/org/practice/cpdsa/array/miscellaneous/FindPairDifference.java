package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;

public class FindPairDifference {

    public boolean findPair(int[] arr, int size, int num) {

        Arrays.sort(arr);

        int i = 0;
        int j = 1;

        while(j < size && i < size) {

            int diff = Math.abs(arr[j] - arr[i]);

            if(diff == num && i != j) {

                return true;
            } else if(diff > num) {

                i++;
            } else {

                j++;
            }
        }
        return false;
    }

}
