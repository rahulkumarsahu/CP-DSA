package org.practice.cpdsa.leetcode.array;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] arr = new int[] {7, 1, 3, 5, 6, 4};
        maxProfit(arr);
        // here maintain the min value and find maximum while going forward.
        int output = maxProfitOptimal(arr);
        System.out.println(output);
    }

    private static int maxProfitOptimal(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] < min) {
                min = arr[i];
            } else {
                max = Math.max(max, arr[i] - min);
            }
        }
        return max;
    }

    private static int maxProfit(int[] arr) {
        int max = 0;

        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] < arr[i + 1]) {
                for (int j = i; j < arr.length - 1; j++) {
                    max = Math.max(max, arr[j] - arr[i]);
                }
            }
        }

        return max;
    }
}
