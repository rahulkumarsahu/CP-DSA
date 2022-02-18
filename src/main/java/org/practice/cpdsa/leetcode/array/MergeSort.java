package org.practice.cpdsa.leetcode.array;

import org.practice.cpdsa.sorting.Helper;

public class MergeSort {

    public static void main(String[] args) {
        int[] listToSort = new int[]{4, 5, 6, 9, 8, 3, 1, 2, 0, 7};
        Helper.print(listToSort);
        int[] sortArray =  mergeSort(listToSort, 0, listToSort.length - 1);
        Helper.print(sortArray);
    }

    private static int[] mergeSort(int[] listToSort, int startIndex, int endIndex) {
        // this is base condition to break the recursive call... when start == end
        if(startIndex != endIndex) {
            // this is to calculate the mid-index
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            // to split first part of array and so on...
            mergeSort(listToSort, startIndex, midIndex);
            // to split second part of array and so on ...
            mergeSort(listToSort, midIndex + 1, endIndex);
            // this is to merge the array after sorting
            merge(listToSort, startIndex, midIndex, endIndex);

        }

        return listToSort;
    }

    private static void merge(int[] listToSort, int startIndex, int midIndex, int endIndex) {
        // this is for first half check starting point
        int i = startIndex;
        // this is for second half check starting point
        int j = midIndex + 1;
        // this is index of temp array
        int k = 0;
        int length = endIndex - startIndex + 1;
        // this is temp array whose size will be endIndex - startIndex + 1; because total element will be if start is 3 and end at 6 -> 4 (6 - 3 + 1)
        int[] temp = new int[length];

        // run the loop till first end or till the second end
        while (i <= midIndex && j <= endIndex) {
            if(listToSort[i] <= listToSort[j]) {
                temp[k++] = listToSort[i++];
            } else {
                temp[k++] = listToSort[j++];
            }
        }

        //now if any element left with one part of array
        while (i <= midIndex) {
            temp[k++] = listToSort[i++];
        }

        //now if any element left with second part of array
        while (j <= endIndex) {
            temp[k++] = listToSort[j++];
        }
        // here assigning i = startIndex and i <= endIndex
        for (i = startIndex; i <= endIndex; i++) {
            listToSort[i] = temp[i - startIndex];
        }
    }

}