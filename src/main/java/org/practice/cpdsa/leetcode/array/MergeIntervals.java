package org.practice.cpdsa.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        // we are considering here this is sort already if not then we have to sort this first using merge sort.
        int[][] arr = new int[][]{ {1,3} , {2,6} , {8,10} , {15,18} };
        List<int[]> intervals = merge(arr);
        System.out.println(Arrays.toString(intervals.toArray()));
    }
    // here if 2 is less than 3 then we can merge and make it 1,6 and similar
    public static List<int[]> merge(int[][] intervals) {
        // storing the output
        List<int[]> result = new ArrayList<>();
        // storing the first and second value from first array for comparison
        int start = intervals[0][0]; // 1
        int end = intervals[0][1]; // 3

        for(int[] arr : intervals) {
            // getting array one by one
            // if the 2 is less than 3 then we have to merge the first and second array
            // and this process will run till we did not find the > element because one and more can be merged
            if(arr[0] <= end) {
                end = Math.max(end, arr[1]);
            } else {
                // adding output to the result
                result.add(new int[]{start, end});
                // assigning the current value to start and end
                start = arr[0];
                end = arr[1];
            }
        }
        // adding the last output
        result.add(new int[]{start, end});
        // return the output
        return result;
    }

}
