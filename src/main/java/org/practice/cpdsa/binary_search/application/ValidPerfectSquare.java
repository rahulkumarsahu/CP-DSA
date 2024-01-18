package org.practice.cpdsa.binary_search.application;

public class ValidPerfectSquare {

    public static void main(String[] args) {
        isPerfectSquare(16);
    }

    public static boolean isPerfectSquare(int num) {

        int start = 1;
        int end = 46340;

        if (num == 1) return true;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
