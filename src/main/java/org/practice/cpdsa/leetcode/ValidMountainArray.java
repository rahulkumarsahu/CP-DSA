package org.practice.cpdsa.leetcode;

import java.util.Scanner;

public class ValidMountainArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The size of array :- ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter The elements of array :- ");
        for(int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        Boolean isValid = validMountainArray(arr);

        System.out.println("The third Maximum number is :- " + isValid);

        scanner.close();
    }

    private static Boolean validMountainArray(int[] arr) {

        int comp = arr[0];
        boolean isStrictlyIncreasing = Boolean.FALSE;
        boolean isStrictlyDecreasing = Boolean.FALSE;

        if(arr.length < 3)
            return Boolean.FALSE;

        for(int i = 1; i <= arr.length - 1; i++) {

            if(comp == arr[i]) {
                return Boolean.FALSE;
            } else if(comp < arr[i]) {
                comp = arr[i];
                if(Boolean.FALSE.equals(isStrictlyDecreasing)) {
                    isStrictlyIncreasing = Boolean.TRUE;
                } else {
                    return Boolean.FALSE;
                }
            } else {
                comp = arr[i];
                isStrictlyDecreasing = Boolean.TRUE;
            }
        }

        if(Boolean.TRUE.equals(isStrictlyIncreasing) && Boolean.TRUE.equals(isStrictlyDecreasing)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
