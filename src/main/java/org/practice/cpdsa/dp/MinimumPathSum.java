package org.practice.cpdsa.dp;

public class MinimumPathSum {

    public static void main(String[] args) {
        // https://leetcode.com/problems/minimum-path-sum/
        int[][] t = new int[5][5];
        int h = t.length;
        int w = t[0].length;

        int output = minimumSumPath(t, h, w);
        System.out.println(output);
    }

    private static int minimumSumPath(int[][] t, int h, int w) {

        if(h == 0 && w == 0) {
            return t[h][w];
        }

        if(h == 0) return t[h][w] + minimumSumPath(t, h, w - 1);
        if(w == 0) return t[h][w] + minimumSumPath(t, h - 1, w);

        return t[h][w] + Math.min(minimumSumPath(t, h, w - 1), minimumSumPath(t, h - 1, w));
    }
}
