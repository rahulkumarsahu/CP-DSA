package org.practice.cpdsa.leetcode.dp;

import java.util.Arrays;

import static java.lang.Math.max;

// choice diagram will be if we want that then we can consider multiple time
// but if we don't want then we will not consider at all
// example ice cream I don't like, so I will reject every time but samosa I can consider multiple
public class UnboundedKnapsack {

    public static void main(String[] args) {

        int[][] t = new int[5][12];
        //Arrays.stream(t).forEach(a -> Arrays.fill(t, -0));

        /**
        int result = unboundedKnapsackTopDownApproach(new int[]{2, 3, 7, 8, 10}, new int[]{}, 5, 5, t);
        System.out.println(result);

        int[][] t1 = new int[6][9];
        // size of array and capacity of array
        Arrays.stream(t).forEach(a -> Arrays.fill(t, -0));
        // matching price -> value and weight -> length from 0/1 Knapsack question
        // length will be 1 to N in increasing order 1,2,3,4,5,6,7,8...
        int rodCutting = rodCuttingProblem(new int[]{}, new int[]{}, 5, 8, t1);
        System.out.println(rodCutting);

        int coinChangeMaximum = coinChangeProblemMaximumNumberOfWays(new int[]{}, 5, 8, t1);
        System.out.println(coinChangeMaximum);
        **/
        int coinChangeMinimum = coinChangeProblemMinimumNumberOfWays(new int[]{9, 6, 5, 1}, 4, 11, t);
        System.out.println(coinChangeMinimum);
    }

    private static int coinChangeProblemMinimumNumberOfWays(int[] coins, int n, int sum, int[][] t) {

        // base condition of recursive -> will be changed in initialization for top-down approach
        // think for smaller possible input n = 0 (length of array), sum = 0 answer? -> 0
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < sum + 1; j++) {
                // for j == 0 there will be empty subset
                if(j == 0) {
                    t[i][j] = 0;
                }
                // here if we will consider we have empty coins but sum = 1 or 2 and so on...
                // then we need Integer.max - 1 coins on i index
                if(i == 0) {
                    t[i][j] = Integer.MAX_VALUE - 1;
                }

            }
        }
        // for i = 1 row if coins[0] is divisible then put value else put integer max
        int k = 1;
        for(int i = 1; k < sum + 1; k++) {
            if(k % coins[0] == 0)
                t[i][k] = k / coins[0];
            else
                t[i][k]= Integer.MAX_VALUE - 1;
        }

        for(int i = 2; i < n + 1; i++) {

            for (int j = 1; j < sum + 1; j++) {

                if(coins[i - 1] <= j) {
                    // here true false is there that is why replace with ||
                    t[i][j] = Math.min(1 + t[i][j - coins[i]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }

    private static int coinChangeProblemMaximumNumberOfWays(int[] coins, int n, int sum, int[][] t) {

        // base condition of recursive -> will be changed in initialization for top-down approach
        // think for smaller possible input n = 0 (length of array), sum = 0 answer? -> 0
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < sum + 1; j++) {
                if(i == 0) {
                    t[i][j] = 0;
                }
                // for j == 0 there will be empty subset
                if(j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for(int i = 1; i < n + 1; i++) {

            for (int j = 1; j < sum + 1; j++) {

                if(coins[i - 1] <= j) {
                    // here true false is there that is why replace with ||
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }

    private static int rodCuttingProblem(int[] length, int[] price, int n, int c, int[][] t) {
        // base condition of recursive -> will be changed in initialization for top-down approach
        // think for smaller possible input w = 0, n = 0
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < c + 1; j++) {
                if(i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        // converting recursive to top-down approach...
        // create choice diagram if w <= weight[n-1] consider to include in knapsack or not consider
        for (int i = 1; i < n + 1; i++) {
            for(int j = 1; j < c + 1; j++) {
                // replacing n with i and w with j....
                if(length[i - 1] <= j) {
                    t[i][j] = max(price[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
                } else if(length[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = 0;
                }
            }
        }

        return t[n][c];
    }

    public static int unboundedKnapsackTopDownApproach(int[] value, int[] weight, int w, int n, int[][] t) {

        // base condition of recursive -> will be changed in initialization for top-down approach
        // think for smaller possible input w = 0, n = 0
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < w + 1; j++) {
                if(i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        // converting recursive to top-down approach...
        // create choice diagram if w <= weight[n-1] consider to include in knapsack or not consider
        for (int i = 1; i < n + 1; i++) {
            for(int j = 1; j < w + 1; j++) {
                // replacing n with i and w with j....
                if(weight[i - 1] <= j) {
                    t[i][j] = max(value[i - 1] + t[i][j - weight[i - 1]], t[i - 1][j]);
               //   t[i][j] = max(value[i - 1] + t[i - 1][j - weight[i - 1]], t[i - 1][j]);
                } else if(weight[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = 0;
                }
            }
        }
        /**
         if(weight[n - 1] <= w) {
         t[n][w] = max(value[n - 1] + t[n - 1][w - weight[n - 1]], t[n - 1][w]);
         return t[n][w];
         } else if(weight[n - 1] > w) {
         t[n][w] = t[n - 1][w];
         return t[n][w];
         } else {
         t[n][w] = 0;
         return t[n][w];
         }
         **/

        return t[n][w];
    }
}
