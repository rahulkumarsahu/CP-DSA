package org.practice.cpdsa.sorting;

//select the first element and compare with others if min found then swap
//select the second element ...
//Complexity O(N^2)
public class SelectionSort {

   public static void selectionSort(int[] listToSort) {
        for(int i = 0; i < listToSort.length; i++) {
            for(int j = i + 1; j < listToSort.length; j++) {
               if(listToSort[i] > listToSort[j]) {
                   Helper.swap(listToSort, i, j);
                   Helper.print(listToSort);
               }
            }
        }
    }

    public static void main(String[] args) {
        int[] listToSort = new int[]{ 4, 5, 6, 9, 8, 3, 1, 2, 0, 7 };
        Helper.print(listToSort);
        selectionSort(listToSort);
    }
}
