package org.practice.cpdsa.array;


//Complexity O(N^2)
public class InsertionSort {


    // here we will consider as first element is sorted
    // and after that from starting we will see if next element is in correct order or not if it is then break
    // else we will swap the value till it reaches the correct position
    public static void insertionSort(int[] listToSort) {
        for(int i = 0; i < listToSort.length - 1; i++) {
            for(int j = i + 1 ; j > 0; j--) {
                if(listToSort[j] < listToSort[j - 1]) {
                    Helper.swap(listToSort, j, j - 1);
                } else {
                    break;
                }
                Helper.print(listToSort);
            }
        }
    }

    public static void main(String[] args) {
        int[] listToSort = new int[]{ 4, 5, 6, 9, 8, 3, 1, 2, 0, 7 };
        Helper.print(listToSort);
        insertionSort(listToSort);
    }
}
