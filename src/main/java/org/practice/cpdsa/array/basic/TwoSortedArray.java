package org.practice.cpdsa.array.basic;

import org.practice.cpdsa.sorting.Helper;

public class TwoSortedArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,4,8,10};
        int[] arr2 = new int[]{2,3,9};

        mergeTwoSorted(arr1, arr2);

    }

    private static void mergeTwoSorted(int[] arr1, int[] arr2) {

        for(int i = 0; i < arr1.length; i++) {

            if(arr2[0] < arr1[i]) {
                int temp = arr2[0];
                arr2[0] = arr1[i];
                arr1[i] = temp;

                swap(arr2);
            }
        }

        Helper.print(arr1);
        Helper.print(arr2);

    }

    private static void swap(int[] arr2) {

        for(int j = 0; j < arr2.length - 1; j++) {

            if(arr2[j] > arr2[j + 1]) {
                int temp = arr2[j];
                arr2[j] = arr2[j + 1];
                arr2[j + 1] = temp;
            }
        }
    }

}
