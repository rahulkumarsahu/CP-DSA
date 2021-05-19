package org.practice.cpdsa.array;

//compare the adjacent element if value is minimum than swap
// again we will compare the adjacent element from starting
// Complexity O(N^2)
public class BubbleSort {


    //here it is starting from last element and if it finds the previous only adjacent value is min then swap
    // if no swap occurs in one iteration that means it got sorted and break from loop
    public static void bubbleSort(int[] listToSort) {
        for(int i = 0; i < listToSort.length; i++) {
            boolean swapped = false;
            for(int j = listToSort.length - 1; j > i; j--) {
                if(listToSort[j] < listToSort[j - 1]) {
                    Helper.swap(listToSort, j, j - 1);
                    swapped = true;
                }
            }
            Helper.print(listToSort);
            if(!swapped){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] listToSort = new int[]{ 4, 5, 6, 9, 8, 3, 1, 2, 0, 7 };
        Helper.print(listToSort);
        bubbleSort(listToSort);
    }
}
