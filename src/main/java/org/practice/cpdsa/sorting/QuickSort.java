package org.practice.cpdsa.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] listToSort = new int[]{ 4, 5, 6, 9, 8, 3, 1, 2, 0, 7 };
        Helper.print(listToSort);
        quickSort(listToSort, 0, listToSort.length - 1);
        Helper.print(listToSort);
    }

    private static void quickSort(int[] listToSort, int start, int end) {

        if(start < end) {
            // here we will get 1st less than element from pivot and greater than element from pivot
            int location = quick(listToSort, start, end);
            // location will be position of pivot where lest side all lesser element and right side all greater element
            // so pivot is already in correct position so in next recursion 0 to pivot - 1 will be first division
            // and pivot + 1 will be second division
            quickSort(listToSort, start, location - 1);
            quickSort(listToSort, location + 1, end);
        }

    }

    private static int quick(int[] listToSort, int start, int end) {
        int pivot = listToSort[start];
        int lb = start;

        // we have to proceed the process till when start and end crosses each other
        // because it is base condition for us when they cross we will get our first pivot in position
        // and left all lesser of pivot and right all greater of pivot
        // loop is for all swap required in one case till both index not crosses because every stop one
        // swap will happen after that continuing the process will take care by while loop
        while(start < end) {
           // if start index element is <= then index will increase else index will be stop for swap
            while(listToSort[start] <= pivot) {
                start++;
            }
            // if end index element is >= then index will decrease else index will be stop for swap
            while(listToSort[end] > pivot) {
                end--;
            }
            // if we got index for swap.
            if(start < end) {
                Helper.swap(listToSort, start, end);
            }
        }

        Helper.swap(listToSort, lb, end);

        return end;
    }
}
