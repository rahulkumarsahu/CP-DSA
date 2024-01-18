package org.practice.cpdsa.array.sort;

import java.util.Arrays;

public class ConcaveArraySort {


    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,4,5};
        int[] output = sortTheConcaveArray(arr);
        Arrays.stream(output).forEach(System.out::println);
    }
    // time complexity in worst case O(N)
    // space complexity O(N)
    private static int[] sortTheConcaveArray(int[] arr) {

        int[] temp = new int[arr.length];
        int leftMostIndex = 0;
        int rightMostIndex = arr.length - 1;
        int counter = 0;

        if(arr.length == 1) return arr;


        while (leftMostIndex < rightMostIndex) {

            if(arr[leftMostIndex] == arr[rightMostIndex]) {
                temp[counter++] = arr[leftMostIndex];
                temp[counter++] = arr[rightMostIndex];
                leftMostIndex++;
                rightMostIndex--;
            } else if(arr[leftMostIndex] < arr[rightMostIndex]) {
                temp[counter++] = arr[leftMostIndex];
                leftMostIndex++;
            } else {
                temp[counter++] = arr[rightMostIndex];
                rightMostIndex--;
            }
        }

        if(counter == arr.length - 1)
            temp[counter] = arr[leftMostIndex];

        return temp;
    }
}
