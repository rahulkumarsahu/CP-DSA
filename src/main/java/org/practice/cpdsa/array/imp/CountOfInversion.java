package org.practice.cpdsa.array.imp;

import java.util.Arrays;

// N(log(N))
public class CountOfInversion {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 9, 6, 4, 5};
        int[] temp = Arrays.copyOf(arr, arr.length);
        int output = mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println(output);

    }

    private static int mergeSort(int[] listToSort, int[] temp, int startIndex, int endIndex) {

        // this is base condition to break the recursive call... when start == end
        if(endIndex <= startIndex) {
            return 0;
        }
        // this is to calculate the mid-index
        int midIndex = startIndex + (endIndex - startIndex) / 2;
        int inversionCount = 0;
        // to split first part of array and so on...
        inversionCount += mergeSort(listToSort, temp, startIndex, midIndex);
        // to split second part of array and so on ...
        inversionCount += mergeSort(listToSort, temp, midIndex + 1, endIndex);
        // this is to merge the array after sorting
        inversionCount += merge(listToSort, temp, startIndex, midIndex, endIndex);

        return inversionCount;
    }

    private static int merge(int[] listToSort, int[] temp, int startIndex, int midIndex, int endIndex) {
        // this is for first half check starting point
        int i = startIndex;
        // this is for second half check starting point
        int j = midIndex + 1;
        // this is index of temp array
        int k = startIndex;

        int inversionCount = 0;

        // run the loop till first end or till the second end
        while (i <= midIndex && j <= endIndex) {
            if(listToSort[i] <= listToSort[j]) {
                temp[k++] = listToSort[i++];
            } else {
                temp[k++] = listToSort[j++];
                // why this? because when array is sorted then if arr[j] >= arr[i] then we can make midIndex - i + 1 count
                inversionCount += (midIndex - i + 1);
            }
        }

        //now if any element left with one part of array
        while (i <= midIndex) {
            temp[k++] = listToSort[i++];
        }

        // here assigning i = startIndex and i <= endIndex
        for (i = startIndex; i <= endIndex; i++) {
            listToSort[i] = temp[i];
        }

        return inversionCount;
    }



}
