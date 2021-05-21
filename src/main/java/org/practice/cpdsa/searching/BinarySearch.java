package org.practice.cpdsa.searching;
// O(logN)
public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedList = new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int numberToSearch = 7;
        int index = binarySearch(sortedList, numberToSearch);
        System.out.println(index);
    }

    private static int binarySearch(int[] sortedList, int numberToSearch) {

        int min = 0;
        int max = sortedList.length - 1;
    // continue till min is <= max
        while(min <= max) {
            // find the mid of the sorted array.
            int mid = min + (max-min) / 2;
            //found in a middle element
            if(sortedList[mid] == numberToSearch) {
                return mid;
            }else if(sortedList[mid] > numberToSearch) {
                // if mid element is > then reduce max because it will be in left side
                max = mid - 1;
            } else {
                // if mid element is < then increase min because it will be in right side
                min = mid + 1;
            }

        }

        return -1;
    }

}
