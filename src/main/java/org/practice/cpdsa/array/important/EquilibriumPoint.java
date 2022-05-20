package org.practice.cpdsa.array.important;

//https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
public class EquilibriumPoint {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,2,2};
        int output = equilibriumPoint(arr, arr.length);
        System.out.println(output);
    }

    private static int equilibriumPoint(int[] arr, int length) {
        int sum = 0;
        int leftSum = 0;

        for(int i = 0; i < length; i++) {
            sum += arr[i];
        }
        // sum = 13
        // 1 3 5 2 2
        // sum ->  12 9 4
        // left -> 1  4
        for(int i = 0; i < length; i++) {
            sum -= arr[i];
            System.out.println(sum + "  " + leftSum);
            if(leftSum == sum) return i;

            leftSum += arr[i];
        }

        return -1;
    }
}
