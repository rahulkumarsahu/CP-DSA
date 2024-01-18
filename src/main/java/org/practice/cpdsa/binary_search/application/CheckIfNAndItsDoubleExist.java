package org.practice.cpdsa.binary_search.application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//1346
public class CheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        checkIfExist(new int[]{});
        checkIfExistSet(new int[]{});
    }

    public static boolean checkIfExist(int[] arr) {
        // sorting the array for applying binary search
        Arrays.sort(arr);

        boolean result;

        for(int i = 0; i < arr.length; i++) {
            // if current index value % 2 == 0, and it is < 0 then only its division by 2 can be there
            // in upcoming indexes otherwise if it is positive then its double will be there in upcoming indexes.
            // because array is sorted.
            if(arr[i] % 2 == 0 && arr[i] < 0) {
                result = binarySearch(arr, i + 1, arr.length - 1, arr[i]/2);
            } else {
                result = binarySearch(arr, i + 1, arr.length - 1, arr[i]*2);
            }

            if(result) return true;
        }

        return false;
    }

    private static boolean binarySearch(int[] arr, int start, int end, int target) {

        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    public static boolean checkIfExistSet(int[] arr) {

        Set<Integer> checkSet = new HashSet<>();

        for (int element : arr) {

            int data = element % 2 == 0 ? element / 2 : -1;

            if ((checkSet.contains(element * 2)) || (checkSet.contains(element / 2) && data != -1)) {

                return true;
            } else {

                checkSet.add(element);
            }
        }

        return false;
    }
}
