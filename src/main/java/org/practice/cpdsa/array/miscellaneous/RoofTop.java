package org.practice.cpdsa.array.miscellaneous;

public class RoofTop {


    public static int maxStep(int[] arr, int n) {

        int maxStep = 0;
        int count = 0;

        for(int i = 0; i < arr.length - 1; i++) {

            if(arr[i] < arr[i + 1]) {

                count++;

            } else {

                maxStep = Math.max(maxStep, count);
                count = 0;
            }
        }

        return Math.max(maxStep, count);
    }
}
