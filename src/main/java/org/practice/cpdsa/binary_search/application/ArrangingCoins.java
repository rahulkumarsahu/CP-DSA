package org.practice.cpdsa.binary_search.application;

public class ArrangingCoins {
    public static void main(String[] args) {
        arrangeCoins(8);
    }

    public static int arrangeCoins(int n) {
        // When our "start" is greater than our "end", our "start" will be set to an incomplete row and our "end" will
        // be set to a complete row, so we return "end"
        int start = 0;
        int end = n;
        while (start <= end) {

            int mid = start + (end - start) / 2;

            int sum = mid * (mid + 1) / 2;

            if (sum == n) {
                return mid;
            }else if(sum < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }
}
