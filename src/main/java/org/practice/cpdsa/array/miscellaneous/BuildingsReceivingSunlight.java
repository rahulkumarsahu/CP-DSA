package org.practice.cpdsa.array.miscellaneous;

public class BuildingsReceivingSunlight {

    public static int longest(int[] arr, int n) {

        int maxStep = arr[0];
        int count = 1;

        for(int i = 1; i < arr.length; i++) {


            if(arr[i] >= maxStep) {
                maxStep = arr[i];
                count++;
            }


        }

        return count;

    }
}
