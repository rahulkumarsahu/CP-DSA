package org.practice.cpdsa.binary_search.application;

public class NearlySortedArray {

    public static void main(String[] args) {
        int[] arr =new int[]{10, 5, 20, 30, 40};
        int target = 5;
        int output = searchInNearlySortedArray(arr, target);
        System.out.println(output);
    }

    // nearly sorted means 10 30 20
    // so in nearly sorted array the value can be possible in + 1 or - 1 so searching accordingly
    // as we are checking + 1 and - 1 so adding + 2 and - 2 as it is already checked
    public static int searchInNearlySortedArray(int[] arr, int target) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while(startIndex <= endIndex) {

            int midIndex = startIndex + (endIndex - startIndex) / 2;
            //
            if (arr[midIndex] == target) {
                return midIndex;
            } else if(midIndex - 1 > 0 && arr[midIndex - 1] == target) {
                return midIndex -1;
            } else if(midIndex + 1 < arr.length - 1 && arr[midIndex + 1] == target) {
                return midIndex + 1;
            } else if (target > arr[midIndex]) {
                startIndex = midIndex + 2;
            } else {
                endIndex = midIndex - 2;
            }
        }

        return -1;

    }

}
