package org.practice.cpdsa.array;

// complexity O(N^3/2)
public class ShellSort {


     // 4 5 6 9 8 3 1 2 0 7
    // here in shell sort there will be start index in which we will increment by position and swap
    // suppose start index is 0 and increment is 5 and length of array is 10
/*          4 5 6 9 8 3 1 2 0 7
            3 5 6 9 8 4 1 2 0 7
            3 5 6 9 7 4 1 2 0 8
            3 1 6 9 7 4 5 2 0 8
            3 1 2 9 7 4 5 6 0 8
            3 1 2 0 7 4 5 6 9 8
            2 1 3 0 7 4 5 6 9 8
            2 1 3 0 5 4 7 6 9 8
            2 0 3 1 5 4 7 6 9 8
            0 2 3 1 5 4 7 6 9 8
            0 2 1 3 5 4 7 6 9 8
            0 1 2 3 5 4 7 6 9 8
            0 1 2 3 4 5 7 6 9 8
            0 1 2 3 4 5 6 7 9 8
            0 1 2 3 4 5 6 7 8 9*/
    public static void shellSort(int[] listToSort, int startIndex, int increment) {
        for(int i = startIndex; i < listToSort.length - 1; i = i + increment) {
            for(int j = Math.min(i + increment, listToSort.length - 1) ; j - increment >= 0; j = j - increment) {
                if(listToSort[j] < listToSort[j - increment]) {
                    Helper.swap(listToSort, j, j - increment);
                } else {
                    break;
                }
                Helper.print(listToSort);
            }
        }
    }

    public static void shellSort(int[] listToSort) {
        int increment = listToSort.length / 2;
        while(increment >= 1) {
            for(int startIndex = 0; startIndex < increment; startIndex++) {
                shellSort(listToSort, startIndex, increment);
            }
            increment = increment / 2;
        }
    }

    public static void main(String[] args) {
        int[] listToSort = new int[]{ 4, 5, 6, 9, 8, 3, 1, 2, 0, 7 };
        Helper.print(listToSort);
        shellSort(listToSort);
    }

}
