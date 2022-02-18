package org.practice.cpdsa.leetcode.array;

public class RotateImage {

    public static void main(String[] args) {

        int[][] arr = { { 10, 20, 30, 40 }, { 15, 25, 35, 45}, { 27, 29, 37, 48 }, { 32, 33, 39, 50} };
        rotateImage90Degree(arr);

    }
    // to rotate 90 degree traverse and reverse O(n^2) + O(n^2)
    public static void rotateImage90Degree(int[][] arr) {
        // this is to traverse the matrix...
        // to traverse the matrix we have to exchange the row and column
        // ,so we will assign j = i because in first iteration others are already change...

        for(int i = 0; i < 4; i++) {
            for(int j = i; j < 4; j++) {
                System.out.println(arr[i][j]);
                System.out.println(arr[j][i]);
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
         // N^2 + N^2
        // this is to reverse the matrix...
        for(int i = 0; i < arr.length; i++) {
            // here to reverse initialize the constants because it will start from 0 and run till length - 1;
            int start = 0;
            int end = 4-1;
            // use two pointer algorithm to reverse the array
            // one start from 0 and other is start from end
            // and swap both till start < end
            while (start < end) {
                // Swap the element
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;

                // Increment start and decrement
                // end for next pair of swapping
                start++;
                end--;
            }
        }
    }
}
