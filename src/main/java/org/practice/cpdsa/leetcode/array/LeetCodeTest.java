package org.practice.cpdsa.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeTest {

    public static void main(String[] args) {

        int output = maximumAverage(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7});
        System.out.println(output);

    }

    private static int maximumAverage(int[] A, int[] B) {

        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
