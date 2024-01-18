package org.practice.cpdsa.binary_search.application;

public class SearchInsertPosition {

    public static void main(String[] args) {
        searchInsert(new int[]{}, 5);
    }

    public static int searchInsert(int[] num, int target) {

        int start = 0;
        int end = num.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(num[mid] == target) {
                return mid;
            } else if(num[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
