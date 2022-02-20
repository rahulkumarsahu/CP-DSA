package org.practice.cpdsa.leetcode.array;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int[] arr = new int[] {7, 1, 3, 5, 6, 4};
        int data = maxProfit(arr);
        // here maintain the min value and find maximum while going forward.
        int output = maxProfitOptimal(arr);
        int maxOutput = maxProfitForTwoSellAndBuy(arr);
        System.out.println(output);
        System.out.println(data);
        System.out.println(maxOutput);
    }

    private static int maxProfitForTwoSellAndBuy(int[] arr) {
        // this is the temp array to store the max profit
        int[] temp = new int[arr.length];
        // length of array
        int k = arr.length;
        // storing 0 into temp array
        for(int i = 0; i < arr.length; i++)
            temp[i] = 0;
        // input :- 2, 4, 2, 6, 2, 3
        // this is to get max profit from arr[0] index

        // consider max profit is 3
        int maxProfit = arr[k - 1];
        // run loop from length - 2, means from 4th index
        for(int j = k - 2; j >= 0; j--) {
               // check 2 > 3 or not if yes then update the max profit
               // we are checking condition because if value is maximum then we can get max profit
               // example 2, 6 case max profit get updated to 6 and when we reach 2 we get max profit as 4
               if(arr[j] > maxProfit)
                   maxProfit = arr[j];
               // compare the profit from temp j + 1 index profit to maxProfit - current j index which ever is max consider that as output
               temp[j] = Math.max(temp[j + 1], maxProfit - arr[j]);
        }
        // it contains first buy and sell max
        int min = temp[0];
        for (int l = 1; l < arr.length; l++) {

            if(arr[l] < min) {
                min = arr[l];
            }

            temp[l] = Math.max(temp[l - 1], temp[l - 1] + (temp[l]- min));

        }



        return temp[k - 1];
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
