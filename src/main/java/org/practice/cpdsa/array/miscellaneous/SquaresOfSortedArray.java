package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static int[] sortSquaredArray(int[] a) {

        int[] b = new int[a.length];
        int index = a.length -1;

        int i = 0;
        int j = a.length -1;

        while(i < j) {
            int x;
            if(Math.abs(a[i]) <= Math.abs(a[j])) {
                x = a[j] * a[j];
                j--;
            } else {
                x = a[i] * a[i];
                i++;
            }
            b[index] = x;
            index--;
        }
        //last position
        b[index] = a[i]*a[i];

        return b;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortSquaredArray(new int[]{-4, -1, 0, 3, 10})));
    }
}
