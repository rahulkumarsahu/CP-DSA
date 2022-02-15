package org.practice.cpdsa.leetcode.binary_search.application;

import java.util.Arrays;

public class MatrixSortedArraySearching {

    public static void main(String[] args) {
        int[][] arr = { { 10, 20, 30, 40 }, { 15, 25, 35, 45}, { 27, 29, 37, 48 }, { 32, 33, 39, 50} };
        int i = 4;
        int j = 4;
        int target = 32;
        int[] output = matrixBinarySearch(arr, i, j, target);
        System.out.println(Arrays.toString(output));
        
        
    }

    private static int[] matrixBinarySearch(int[][] arr, int i, int j, int target) {

        int rowIndex = 0;
        int columnIndex = j - 1;
        int[] output = new int[2];


        while(rowIndex >= 0 && columnIndex >= 0 && rowIndex <= i - 1 && columnIndex <= j - 1) {

            if(arr[rowIndex][columnIndex] == target) {
                output[0] = rowIndex;
                output[1] = columnIndex;
                return output;
            } else if(target > arr[rowIndex][columnIndex]) {
                rowIndex++;
            } else {
                columnIndex--;
            }

        }

        output[0] = -1;
        output[1] = -1;
        return output;
    }
}
