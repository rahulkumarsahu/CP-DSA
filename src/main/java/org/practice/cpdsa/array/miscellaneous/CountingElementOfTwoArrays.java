package org.practice.cpdsa.array.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingElementOfTwoArrays {

    public static List<Integer> countEleLessThanOrEqual(int[] arr1, int[] arr2) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(arr2);

        for(int val : arr1) {

            int index = applyBinarySearch(arr2, val);

            if(arr2[index] == val) {
                ans.add(index + 1);
            } else if(arr2[index] < val) {
                ans.add(index + 1);
            } else if(arr2[index] > val) {
                ans.add(index);
            }
        }

        return ans;

    }
    public static int applyBinarySearch(int[] arr, int val) {
        int high = arr.length-1;
        int low = 0;
        int mid = -1;

        while(low <= high) {
            mid = (low + high) / 2;

            if(arr[mid] == val) {
                low = mid + 1;
            } else if(arr[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return mid;
    }
}
