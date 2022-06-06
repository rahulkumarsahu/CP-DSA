package org.practice.cpdsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

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
                Helper.print(listToSort);
            }
            //Helper.print(listToSort);
            if(!swapped){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] listToSort = new int[]{ 3, 2, 4, 1, 5};
        Helper.print(listToSort);
        bubbleSort(listToSort);
    }

    void kTop(node[] arr, int n) {
        Arrays.sort(arr, (a, b) -> {

            if(a.marks == b.marks) return Integer.compare(a.index, b.index);

            return Integer.compare(b.marks, a.marks);
        });


    }

    class node
    {
        int marks;
        int index;
        public void setMarks(int a)
        {
            this.marks=a;
        }
        public void setIndex(int b)
        {
            this.index=b;
        }
    }
}
