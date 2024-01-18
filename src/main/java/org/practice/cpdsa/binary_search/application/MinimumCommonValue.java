package org.practice.cpdsa.binary_search.application;

public class MinimumCommonValue {

    public static void main(String[] args) {
        getCommon(new int[]{}, new int[]{});
    }

    public static int getCommon(int[] num1, int[] num2) {

        boolean found = false;

        for (int i = 0; i < num1.length; i++) {

            if(search(num1[i], num2)) {
                return num1[i];
            }
        }

        return -1;
    }

    public static boolean search(int target, int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
