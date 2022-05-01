package org.practice.cpdsa.array;
// N*M -> time
// N*M -> space
public class UniquePaths {

    public static void main(String[] args) {
           countUniquePath(0, 0, 2, 3);
           countUniquePathDP(0, 0, 2, 3, new int[2][3]);
    }

   public static int countUniquePath(int i, int j, int m, int n) {
        // this means that we have reached the finish point when i == m and j == n
        if(i == m - 1 && j == n - 1) return 1;
        // to break out from recursion we will write base condition when i and j crosses boundary i > m and j > n
       if(i > m || j > n) return 0;
       //here we can move right or down so for going down increase i by 1 and for going right increase j by 1
       else return countUniquePath(i + 1, j, m, n) + countUniquePath(i, j + 1, m, n);
   }
    // here dp will be having initially -1
    public static int countUniquePathDP(int i, int j, int m, int n, int[][] dp) {
        // this means that we have reached the finish point when i == m and j == n
        if(i == m - 1 && j == n - 1) return 1;
        // to break out from recursion we will write base condition when i and j crosses boundary i > m and j > n
        if(i > m || j > n) return 0;
        // if it is already calculated then return from dp storage
        if(dp[i][j] != -1) return dp[i][j];
        //here we can move right or down so for going down increase i by 1 and for going right increase j by 1
        else return dp[i][j] = countUniquePathDP(i + 1, j, m, n, dp) + countUniquePathDP(i, j + 1, m, n, dp);
    }
}
