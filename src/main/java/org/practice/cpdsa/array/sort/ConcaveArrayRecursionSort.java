package org.practice.cpdsa.array.sort;

import java.util.Arrays;

public class ConcaveArrayRecursionSort {

    static int[] arr = new int[]{30,15,12,11};
    static int[] temp = new int[arr.length];

    public static void main(String[] args) {

        sortTheConcaveArray(arr, 0, arr.length - 1, 0);
        Arrays.stream(temp).forEach(System.out::println);
    }

    private static void sortTheConcaveArray(int[] arr, int leftMostIndex, int rightMostIndex, int counter) {

        if(arr.length == 1) return;

        if(leftMostIndex >= rightMostIndex) {

            if(counter == arr.length - 1)
                temp[counter] = arr[leftMostIndex];

            return;

        }

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

        sortTheConcaveArray(arr, leftMostIndex, rightMostIndex, counter);
    }

}
