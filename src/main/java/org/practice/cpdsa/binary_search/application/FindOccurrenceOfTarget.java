package org.practice.cpdsa.binary_search.application;

import static org.practice.cpdsa.binary_search.application.FirstAndLastPosition.firstOccurrence;
import static org.practice.cpdsa.binary_search.application.FirstAndLastPosition.lastOccurrence;

public class FindOccurrenceOfTarget {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 9};
        int target = 8;
        int count = findOccurrenceOfTarget(nums, target);
        System.out.println("The Occurrence of target is :- " + count);
    }

    private static int findOccurrenceOfTarget(int[] nums, int target) {
        // this is sorted array so occurrence can be calculated by the last and first index
        return (lastOccurrence(nums, target) - firstOccurrence(nums, target)) + 1;
    }
}
