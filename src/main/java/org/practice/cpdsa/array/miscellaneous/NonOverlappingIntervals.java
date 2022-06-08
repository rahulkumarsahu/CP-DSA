package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int data = intervals[0][1];

        int count = 1;

        for(int i = 1; i < intervals.length; i++) {

            if(intervals[i][0] < data) {

                // updating the intersection point to get the overlapping interval....
                data = Math.min(intervals[i][1], data);
            } else {

                // calculate the non overlapping count....
                data = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;

    }

    public int eraseOverlapIntervals2(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int data = intervals[0][1];

        int count = 0;

        for(int i = 1; i < intervals.length; i++) {

            if(intervals[i][0] < data) {

                // updating the intersection point to get the overlapping interval....
                count++;
                data = Math.min(intervals[i][1], data);
            } else {

                // calculate the non overlapping count....
                data = intervals[i][1];
            }
        }

        return count;

    }
}
