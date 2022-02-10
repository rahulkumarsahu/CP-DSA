package org.practice.cpdsa.leetcode.binary_search;

public class SearchingInfiniteArray {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                25, 26, 27, 28, 29, 30};
        int target = 15;
        int output = findTheRange(arr, target);
        System.out.println("The Output is :- " + output);
    }


    // so as it is an infinite array, so we will not be having endpoint so how we can solve?
    // in binary search we will break array in smaller parts in every iteration and reach till size is one.
    // so here why not we can think in reverse way we will start with one and increase till we reach arr.length
    // here basic idea is to find the range where we can search and return the output,
    // so we are starting from 0 and end at 1 at box of 2 and checking target can be lying in that part of chunk or not
    // if it is not lying then no need to search on that space, so we can go for another chunk and do same process
    // once we find our search space we will do search and return output
    private static int findTheRange(int[] arr, int target) {
        // will start is BOX of 2
        int startIndex = 0;
        int endIndex = 1;
       // here we will increase the start or end Index when target element is greater than arr[endIndex]
        while(target > arr[endIndex]) {
            // here if target doesn't come in first chunk then it will be part of next chunk so next chunk
            // will be starting from endIndex + 1
            int temp = endIndex + 1;
            // increasing end index exponentially
            // 1
            // 5 = 1 + (1 - 0 + 1) * 2
            // 13 = 5 + (5 - 2 + 1) * 2
            // 29 = 15 + (13 - 6 + 1) * 2
            endIndex = endIndex + (endIndex - startIndex + 1) * 2;
            // 0
            // 1 + 1 = 2
            // 5 + 1 = 6
            startIndex = temp;
        }

        return searchingInfiniteArray(arr, target, startIndex, endIndex);
    }

    private static int searchingInfiniteArray(int[] arr, int target, int startIndex, int endIndex) {

        while(startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if(arr[midIndex] == target) {
                return midIndex;
            } else if(target > arr[midIndex]) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        return -1;
    }


    // here time complexity is more bad solution
    /**
    private static int searchingInfiniteArray(int[] arr, int target, int start, int end) {

        int startIndex = start;
        int endIndex = end;
        int output = -1;
        int length = endIndex;

        while(startIndex < endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if(arr[midIndex] == target) {
                output = midIndex;
                endIndex = midIndex - 1;
            } else if(target > arr[midIndex]) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        if(output != -1) {
            return  output;
        } else {
              startIndex = length;
              endIndex = length + 10;
              output =  searchingInfiniteArray(arr, target, startIndex, endIndex);

        }

        return output;
    }
    **/
}
