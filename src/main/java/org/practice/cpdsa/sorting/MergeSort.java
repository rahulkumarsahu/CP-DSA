package org.practice.cpdsa.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] listToSort = new int[]{ 4, 5, 6, 9, 8, 3, 1, 2, 0, 7 };
        Helper.print(listToSort);
        mergeSort(listToSort, 0, listToSort.length - 1);
    }

    private static void mergeSort(int[] listToSort, int start, int end) {
        // start == end will be the case when by dividing array it became of size 1.
        if(start != end) {
            // in first call start = 0 and end = 9 so mid = 4
            // in second recursive call start will be 0 and end will be 4 so mid = 2
            int mid = (start + end) / 2;
            // so first division will be 0 to 4 for below merge sort recursive call
            // so second recursive call division will be 0 to 2 and 3 to 4 similarly for all....
            mergeSort(listToSort, start, mid);
            // so first division will be 5 to 9 for below merge sort recursive call
            // so second recursive call  start = 5 and end = 9  so mid = 7 so division will be 5 to 7 and 8 to 9
            mergeSort(listToSort, mid + 1, end);
            // after all division merge the array.
            merge(listToSort, start, mid, end);
            // print the array
            Helper.print(listToSort);
        }

    }

    private static void merge(int[] listToSort, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;

        int[] temp = new int[end - start + 1];

        while ((i <= mid) && (j <= end)) {
            if (listToSort[i] < listToSort[j])
                temp[k++] = listToSort[i++];
            else
                temp[k++] = listToSort[j++];
        }

        while (i <= mid) {
            temp[k++] = listToSort[i++];
        }

        while (j <= end) {
            temp[k++] = listToSort[j++];
        }

        for (i = start; i <= end; i++) {
            listToSort[i] = temp[i - start];
        }
    }
}
