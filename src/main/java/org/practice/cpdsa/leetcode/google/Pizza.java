package org.practice.cpdsa.leetcode.google;


public class Pizza {

    public static void main(String[] args) {

        int[] price = new int[]{1100, 900};
        int[] toppings = new int[]{200};
        int x = 1000;

        int result = closestPrice(price, toppings, x);
        System.out.println(result);
    }

    private static int closestPrice(int[] prices, int[] toppings, int target) {

        int output = 0;
        int[] result = new int[2];
        int targetDifference = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            int minimum = Math.abs(prices[i] - target);
            for(int j = 0; j < toppings.length; j++) {

                int data = prices[i] + toppings[j];
                int difference = Math.abs(data - target);
                if(data == target) {
                    return data;
                } else if (minimum <= difference) {
                    output = prices[i];
                } else if (difference <= targetDifference) {
                    result[0] = i;
                    result[1] = j;
                }

                targetDifference = Math.min(difference, targetDifference);
            }

        }

        return Math.abs(target - output) < Math.abs((prices[result[0]] + toppings[result[1]]) - target) ?
                output : prices[result[0]] + toppings[result[1]];
    }
}
