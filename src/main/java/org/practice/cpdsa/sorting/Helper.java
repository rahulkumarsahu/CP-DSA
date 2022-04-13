package org.practice.cpdsa.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Helper {

    public static void print(int[] listToSort) {
        for (int el : listToSort) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public static void printString(String[] listToSort) {
        for (String el : listToSort) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public static void swap(int[] listToSort, int iIndex, int jIndex) {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for(int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }

        for(int i = arr.length-1; i >= 0; i--) {
            System.out.println(arr[i]+" ");
       }

    }
}
