package org.practice.cpdsa.array.important;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1
public class LargestNumberFormed {

    public static void main(String[] args) {

        String[] arr = new String[]{"3", "30", "34", "9"};

        printLargest(arr);
    }

    /**
     * i
     * 3, 30, 34, 9
     *     j -> i + 1
     *  ---------------------------------------------------------------------
     *  here i is pointing to 0 index and j is incrementing
     *  suppose -> 3, 30 -> 303 or 330 possibility -> so 330 will be maximum
     *  3 30 34 9 , so order will not be changed
     *  now 3, 34 -> 334 or 343 -> so swap 34 and 3,
     *  34 30 3 9, order will be changed here
     *  now 34, 9 -> 349, 934 -> so swap 9 and 34
     *  -----------------------------------------------------------------------
     *  9, 30, 3, 34, now i will point to 1st index...
     *  now 30, 3 -> 303, 330 so swap 3, 30,
     *  9, 3, 30, 34
     *  now 3, 34 -> 334, 343 so swap 34, 3
     *  9, 34, 30, 3
     *  ---------------------------------------------------------------------------
     *  9, 34, 30, 3, now i will become 2
     *  30, 3 -> 303, 330 so swap 3, 30
     *  9, 34, 3, 30
     *
     */
    private static void printLargest(String[] arr) {
        //
        Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        StringBuilder data = new StringBuilder();
        for(String x:arr) data.append(x);

        System.out.println(data);
    }
}
