package org.practice.cpdsa.array;

public class QuickSort {

    public static void main(String[] args) {
        int[] listToSort = new int[]{ 4, 5, 6, 9, 8, 3, 1, 2, 0, 7 };
        Helper.print(listToSort);
        quickSort(listToSort, 0, listToSort.length - 1);
    }

    private static void quickSort(int[] listToSort, int start, int end) {

    }
}
