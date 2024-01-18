package org.practice.cpdsa.binary_search.application;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {

    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-1,-2,1,2}));
    }

    public static int maximumCount(int[] num) {

        // check if all negative or positive by checking first number
        if(num[0] >  0 || num[num.length - 1] < 0) return num.length;

        int start = 0;
        int end = num.length - 1;
        int mid = 0;

        // getting the count of negative number. take start for counting negative
        while(start <= end) {

            mid = start + (end - start) / 2;

            if(num[mid] < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // eliminating zero...
        int zero = 0;
        int count = start;
        while(num[count] == 0) {
            zero++;
            count++;
        }

        return Math.max(start, num.length - (start) - zero);

    }
}
