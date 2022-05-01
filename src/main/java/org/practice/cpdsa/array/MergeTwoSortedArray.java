package org.practice.cpdsa.array;

import org.practice.cpdsa.sorting.Helper;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] oneSortedArray = new int[]{ 1, 4, 7, 8, 10};
        int[] twoSortedArray = new int[]{ 2, 3, 9 };
        mergeTwoSortedArray(oneSortedArray, twoSortedArray);
        mergeTwoSortedArrayGAP(oneSortedArray, twoSortedArray, oneSortedArray.length, twoSortedArray.length);
        Helper.print(oneSortedArray);
        Helper.print(twoSortedArray);
    }

    private static int nextGap(int gap) {

        if(gap <= 1) {
            return 0;
        }
        return (gap / 2) + (gap % 2);
    }
    // here we will find gap from length and swap gap elements
    // here j - n taking and i - n taking for second array because it starts from 0 and
    // here one time 4 , 2, 1 gap will be there and if we increase in inner loop i and j by 1 then gap will be maintained
    // as j already point to gap and write acc. to j
    private static void mergeTwoSortedArrayGAP(int[] oneSortedArray, int[] twoSortedArray, int n, int m) {

        int gap =  nextGap(n + m);
        while(gap > 0) {
            int i = 0;
            int j = gap;
            while (j < (n + m)) {
                if (j < n && oneSortedArray[i] > oneSortedArray[j]) {
                    int temp = oneSortedArray[i];
                    oneSortedArray[i] = oneSortedArray[j];
                    oneSortedArray[j] = temp;
                } else if (j >= n && i < n && oneSortedArray[i] > twoSortedArray[j - n]) {
                    int temp = oneSortedArray[i];
                    oneSortedArray[i] = twoSortedArray[j - n];
                    twoSortedArray[j - n] = temp;
                } else if (j >= n && i >= n && twoSortedArray[i - n] > twoSortedArray[j - n]) {
                    int temp = twoSortedArray[i - n];
                    twoSortedArray[i - n] = twoSortedArray[j - n];
                    twoSortedArray[j - n] = temp;
                }
                j++;
                i++;
            }
            gap = nextGap(gap);
        }
    }


    // here we will sort second array and swap the data from first array to second array.
    // time complexity O(n*m)
    private static void mergeTwoSortedArray(int[] oneSortedArray, int[] twoSortedArray) {

        for(int i = 0; i <= oneSortedArray.length - 1; i++) {

            if(twoSortedArray[0] < oneSortedArray[i]) {

                int temp = oneSortedArray[i];
                oneSortedArray[i] = twoSortedArray[0];
                twoSortedArray[0] = temp;

                sortTheArray(twoSortedArray);
            }
        }
    }

    private static void sortTheArray(int[] twoSortedArray) {

        for(int j = 0; j < twoSortedArray.length - 1; j++) {

            if(twoSortedArray[j] > twoSortedArray[j + 1]) {
                int temp = twoSortedArray[j];
                twoSortedArray[j] = twoSortedArray[j + 1];
                twoSortedArray[j + 1] = temp;
            }
        }
    }
}
