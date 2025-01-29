package org.practice.cpdsa.array.basic;

import org.practice.cpdsa.sorting.Helper;

public class RotateLeft {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int size = arr.length;
        int k = 2;
        k = k % size;
        int[] output = rotateLeft(arr, k, size);

        Helper.print(output);
    }

    private static int[] rotateLeft(int[] arr, int k, int size) {
        // first k ele rev
        int[] arr1 = reverse(arr, 0, k - 1);
        // k to lst ele rev
        arr1 = reverse(arr1, k, size - 1);
        // reverse whole array
        arr1 = reverse(arr1, 0, size - 1);

        return arr1;
    }


    private static int[] reverse(int[] arr, int i, int j) {

        while (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
            i++;
        }

        return arr;
    }

}