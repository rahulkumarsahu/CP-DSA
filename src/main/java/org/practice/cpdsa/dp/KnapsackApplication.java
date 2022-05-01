package org.practice.cpdsa.dp;

import java.util.Arrays;

import static java.lang.Math.*;

public class KnapsackApplication {

    public static void main(String[] args) {
        // t = new int[n + 1][w + 1]; where suppose max value possible of n and w is 100
        int[][] t = new int[101][101];
        Arrays.stream(t).forEach(a -> Arrays.fill(t, -1));

        int result = knapsack(new int[]{2, 3, 7, 8, 10}, new int[]{}, 5, 5);
        int output = knapsackMemoization(new int[]{2, 3, 7, 8, 10}, new int[]{}, 5, 5, t);
        int answer = knapsackTopDownApproach(new int[]{2, 3, 7, 8, 10}, new int[]{}, 5, 5, t);
        // subset is present which sum is 11?
        // t = new int[n + 1][k + 1]; where n = 5 and k = 11 suppose max value possible of n and w is 100
        boolean[][] t1 = new boolean[6][12];
        Arrays.stream(t).forEach(a -> Arrays.fill(t1, 0));
        Boolean subsetSum = subsetSumProblem(new int[]{2, 3, 7, 8, 10}, 11, 5, t1);
        // divide into two subset and return if both subset sum == equal
        boolean[][] t2 = new boolean[6][12];
        Arrays.stream(t).forEach(a -> Arrays.fill(t1, 0));
        Boolean equalSum = equalSumPartition(new int[]{1, 5, 5, 11}, t2);
        // count of subset of a given sum
        // t = new int[n + 1][sum + 1]
        int[][] t3 = new int[7][11];
        Arrays.stream(t).forEach(a -> Arrays.fill(t3, 0));
        int countSum = countOfSubsetSum(new int[]{2, 3, 5, 6, 8 ,10}, 10, 6, t3);

        // Minimum subset sum difference
        int[][] t4 = new int[7][11];
        Arrays.stream(t).forEach(a -> Arrays.fill(t4, 0));
        int minimumSubset = minimumSubsetSumDifference(new int[]{1, 5, 6, 11}, t4);
        // count how much subset are possible which difference are 1
        int countMinimumSubset = countSubsetGivenDifference(new int[]{1, 5, 6, 11}, 1, t4);

        // here we have given an array we have to assign + or - to every element so difference will be given sum
        int targetSum = targetSum(new int[]{}, 5, t4);


        System.out.println(result);
        System.out.println(output);
        System.out.println(answer);
        System.out.println(subsetSum);
        System.out.println(equalSum);
        System.out.println(countSum);
        System.out.println(minimumSubset);
        System.out.println(countMinimumSubset);
        System.out.println(targetSum);
    }

    private static int targetSum(int[] value, int sum, int[][] t) {
        // here this problem is similar to countSubsetGivenDifference value = 1, 1, 2, 3
        // because +1 +3 = s1, -2 -1 = -s2
        // s1 - s2 = diff
        // same as above
        return 0;
    }

    private static int countSubsetGivenDifference(int[] value, int diff, int[][] t) {
    // sum(s1) - sum(s2) = diff.
    // sum(s1) + sum(s2) = sum(arr)
    // 2sum(s1) = diff + sum(arr)
    // sum(s1) = diff + sum(arr) / 2;
    // here we make this code to count of subset sum
    // so call countOfSubsetSum(value, sum(s1), t);

        return 0;

    }
    // need clarity
    private static int minimumSubsetSumDifference(int[] value, int[][] t) {

        // here we are taking range = sum of all value so min will be 0 and max will be sum
        // so sub set will be s1 and s2 where s2 will be range - s1 and s1 will be s2 - s1
        // after putting s2 value will get this range - 2s1
        // 1. write subset sum code(arr, sum) where arr = value and sum = all value sum of array;
        // 2. create a list from first half of last row which are true
        // 3. then below code will come into picture....
        int min = Integer.MAX_VALUE;
        /**
        for(int i = 0; i < list.size(); i++) {
            min = Math.min(min, Range - 2 * list.getIndex(i));
        }
        **/

        return min;
    }

    private static int countOfSubsetSum(int[] value, int sum, int n, int[][] t) {

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

                if(value[i - 1] <= j) {
                    // here true false is there that is why replace with ||
                    t[i][j] = t[i - 1][j - value[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }

    private static Boolean equalSumPartition(int[] value, boolean[][] t) {

        // if we have to divide into two equal part then if total sum is even then only we can divide into two subset
        // example if sum is 22 then 11 and 11
        // if it is odd then 23 value is integer array then we can not divide into 2 array
        int sum = Arrays.stream(value).sum();
        if(sum % 2 != 0) return false;

        // if sum is even then we have to find one subset whose sum is 22/2 = 11
        // if we find one another will be always possible
        return subsetSumProblem(value, sum / 2, value.length, t);
    }

    private static Boolean subsetSumProblem(int[] value, int k, int n, boolean[][] t) {
        // base condition of recursive -> will be changed in initialization for top-down approach
        // think for smaller possible input n = 0 (length of array), k = 0 answer? -> true
        // if n = 0 , k = 2 answer? -> false
        // here n = i and k = j
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < k + 1; j++) {
                if(i == 0) {
                    t[i][j] = false;
                }
                if(j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for(int i = 1; i < n + 1; i++) {

            for(int j = 1; j < k + 1; j++) {

            // if we are given only one array then we will ignore value array and consider only weight array...
            // when we apply knapsack problem logic here...
            // weight == value here
            // create choice diagram if w <= weight[n-1] consider to include in knapsack or not consider
                if(value[i - 1] <= j) {
                    // here true false is there that is why replace with ||
                    t[i][j] = t[i - 1][j - value[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][k];
    }

    private static int knapsackTopDownApproach(int[] value, int[] weight, int w, int n, int[][] t) {
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
                    t[i][j] = max(value[i - 1] + t[i - 1][j - weight[i - 1]], t[i - 1][j]);
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

    // here you have given a value and weight array find the maximum profit you can make and there is a limited Knapsack W
    public static int knapsack(int[] value, int[] weight, int w, int n) {

        // base condition
        // think for smaller possible input w = 0, n = 0
        if(w == 0 || n == 0)
            return 0;

        // create choice diagram if w <= weight[n-1] consider to include in knapsack or not consider
        if(weight[n - 1] <= w) {
            return max(value[n - 1] + knapsack(value, weight, w - weight[n - 1], n - 1),
                    knapsack(value, weight, w, n - 1));
        }else if(weight[n - 1] > w) {

            return knapsack(value, weight, w, n - 1);
        } else {
            return 0;
        }
    }

    public static int knapsackMemoization(int[] value, int[] weight, int w, int n, int[][] t) {

        // base condition
        // think for smaller possible input w = 0, n = 0
        if(w == 0 || n == 0)
            return 0;

        // for memoization
        if(t[n][w] != -1) return t[n][w];

        // create choice diagram if w <= weight[n-1] consider to include in knapsack or not consider
        if(weight[n - 1] <= w) {
            // to store the value in t[n][w]
            t[n][w] = max(value[n - 1] + knapsack(value, weight, w - weight[n - 1], n - 1),
                    knapsack(value, weight, w, n - 1));
            return t[n][w];
        }else if(weight[n - 1] > w) {

            t[n][w] = knapsack(value, weight, w, n - 1);
            return t[n][w];
        } else {
            return 0;
        }
    }


}
