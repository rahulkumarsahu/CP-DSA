package org.practice.cpdsa.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        
        String x = "abcdgh";
        String y = "abedfghr";

        int n = x.length();
        int m = y.length();

        int[][] t = new int[n + 1][m + 1];
        Arrays.stream(t).forEach(a -> Arrays.fill(t, -1));
        
        Integer output = longestCommonSubsequence(x, y, n, m);
        Integer result = longestCommonSubsequenceMemoization(x, y, n, m, t);
        Integer answer = longestCommonSubsequenceTopDownApproach(x, y, n, m, t);

        Integer substring = longestCommonSubstring(x, y, n, m, t);

        String subsequence = printLongestCommonSubsequence(x, y, n, m, t);
        
        Integer shortestCommonSubsequence = shortestCommonSubsequence(x, y, n, m, t);

        Integer minimumNumber = minimumNumberOfInsertionAndDeletionToConvertAStringIntoB(x, y, n, m, t);

        Integer longestPalindrome = longestPalindromeSubsequence(x, n, m, t);

        Integer minimumNumberPalindrome = minimumNumberOfInsertionAndDeletionToConvertPalindrome(x, y, n, m, t);

        String printShortestCommonSubsequence = printShortestCommonSubsequence(x, y, n, m, t);

        Integer repeating = longestRepeatingSubsequence(x, y, n, m, t);

        Boolean status = sequencePatternMatching(x, y, n, m, t);

        Integer minimumNumberInsertion = minimumNumberInsertionPalindrome(x, n, t);
        
        System.out.println(output);
        System.out.println(result);
        System.out.println(answer);
        System.out.println(substring);
        System.out.println(subsequence);
        System.out.println(shortestCommonSubsequence);
        System.out.println(minimumNumber);
        System.out.println(longestPalindrome);
        System.out.println(minimumNumberPalindrome);
        System.out.println(printShortestCommonSubsequence);
        System.out.println(repeating);
        System.out.println(status);
        System.out.println(minimumNumberInsertion);

    }

    private static Integer minimumNumberInsertionPalindrome(String x, int n, int[][] t) {
          // number of deletion == number of insertion
        return 0;
    }

    private static Boolean sequencePatternMatching(String x, String y, int n, int m, int[][] t) {
    // is a subsequence of b
        // if lcs == x.length

        return true;

    }

    private static Integer longestRepeatingSubsequence(String x, String y, int n, int m, int[][] t) {
    //  same as lcs with one change
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < m + 1; j++) {
                if(i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        // i -> n
        // j -> m
        for (int i = 1; i < n + 1; i++) {

            for (int j = 1; j < m + 1; j++) {

                if(x.charAt(i - 1) == y.charAt(j - 1) && i != j) {

                    // we got one common character
                    t[i][j] = 1 + longestCommonSubsequence(x, y, i - 1, j - 1);

                } else {
                    // here two choices if it does not match then consider from one
                    // and in second consider from second and take maximum from them
                    // from input h != r, but it can be possible in other index that is why

                    t[i][j] =  Math.max(longestCommonSubsequence(x, y, i, j - 1),
                            longestCommonSubsequence(x, y, i - 1,  j));
                }
            }
        }

        return t[n][m];
    }

    private static String printShortestCommonSubsequence(String x, String y, int n, int m, int[][] t) {
     // print lcs = get lcs string...
     //

        List<Character> list = new ArrayList<>();
        int i = m;
        int j = n;
        // when i reaches 0 and j reaches 0
        // will have empty string so ignoring index for i and j
        while(i > 0 && j > 0) {
            // if equals then will insert into list check plcs diagram
            if(x.charAt(i - 1) == y.charAt(j - 1)) {
                list.add(x.charAt(i + 1));
                // if equal we are moving i-- and j--
                i--;
                j--;
            } else {
                // if not equal then taking maximum and moving in that direction
                if(t[i][j - 1] > t[i - 1][j]) {
                    list.add(y.charAt(j - 1));
                    j--;
                } else if(t[i - 1][j] > t[i][j - 1]) {
                    list.add(x.charAt(i - 1));
                    i--;
                }
            }
        }
        // this extra needed because we want lcs + x,y string also
        // so if any of the length is greater it will get added as it is at last
        while (i > 0) {
            list.add(x.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            list.add(y.charAt(j - 1));
            j--;
        }


        // return list in reverse order
        StringBuilder s = new StringBuilder();
        for(int k = list.size() - 1; k > 0; k--) {
            s.append(list.get(k));
        }

        return s.toString();
    }

    private static Integer minimumNumberOfInsertionAndDeletionToConvertPalindrome(String x, String y, int n, int m, int[][] t) {
     // length of string - lps

        return 1;

    }

    private static Integer longestPalindromeSubsequence(String x, int n, int m, int[][] t) {
        // LPS?
        // LPS = lcs (x, reverse of x);
        // agbcba

        // return length of lcs

        return 5;
    }

    private static Integer minimumNumberOfInsertionAndDeletionToConvertAStringIntoB(String x, String y, int n, int m, int[][] t) {
    // heap -> pea
    // find lcsubstring -> "ea"
    // number of deletion = a.length - lcs.length
    // number of insertion = b.length - lcs
    // deletion + insertion

    return 3;
    }

    private static Integer shortestCommonSubsequence(String x, String y, int n, int m, int[][] t) {
        // to find this
        // a: AGGTAB b: GXTXAYB
        // AGGXTXAYB
        // lcs = GTAB -> first find lcs because common we are considering only once
        //  a + b - lcs = 6 + 7 - 4 = 9 = m + n - lcs = length of the shortest subsequence
        return 9;
    }

    private static String printLongestCommonSubsequence(String x, String y, int n, int m, int[][] t) {
        List<Character> list = new ArrayList<>();
        int i = m;
        int j = n;
     // when i reaches 0 and j reaches 0
      // will have empty string so ignoring index for i and j
      while(i > 0 && j > 0) {
          // if equals then will insert into list check plcs diagram
          if(x.charAt(i - 1) == y.charAt(j - 1)) {
              list.add(x.charAt(i + 1));
              // if equal we are moving i-- and j--
              i--;
              j--;
          } else {
              // if not equal then taking maximum and moving in that direction
              if(t[i][j - 1] > t[i - 1][j]) {
                  j--;
              } else {
                  i--;
              }
          }
      }


      // return list in reverse order
        StringBuilder s = new StringBuilder();
        for(int k = list.size() - 1; k > 0; k--) {
            s.append(list.get(k));
        }

        return s.toString();
    }

    // continuous string 
    private static Integer longestCommonSubstring(String x, String y, int n, int m, int[][] t) {
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < m + 1; j++) {
                if(i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        // i -> n
        // j -> m
        for (int i = 1; i < n + 1; i++) {

            for (int j = 1; j < m + 1; j++) {

                if(x.charAt(i - 1) == y.charAt(j - 1)) {

                    // we got one common character
                    t[i][j] = 1 + t[i - 1][j - 1];

                } else {
                    // here two choices if it does not match then consider from one
                    // and in second consider from second and take maximum from them
                    // from input h != r, but it can be possible in other index that is why

                    t[i][j] =  0;
                }
            }
        }

        return t[n][m];
    }

    private static Integer longestCommonSubsequenceTopDownApproach(String x, String y, int n, int m, int[][] t) {

        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < m + 1; j++) {
                if(i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        // i -> n
        // j -> m
        for (int i = 1; i < n + 1; i++) {

            for (int j = 1; j < m + 1; j++) {

                if(x.charAt(i - 1) == y.charAt(j - 1)) {

                    // we got one common character
                    t[i][j] = 1 + t[i - 1][j - 1];

                } else {
                    // here two choices if it does not match then consider from one
                    // and in second consider from second and take maximum from them
                    // from input h != r, but it can be possible in other index that is why

                    t[i][j] =  Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }

        return t[n][m];
    }

    private static Integer longestCommonSubsequenceMemoization(String x, String y, int n, int m, int[][] t) {
        // base condition
        // the smallest input will be x = "", y = ""

        if (n == 0 || m == 0) {
            return 0;
        }

        if(t[n][m] != -1) return t[n][m];

        // choice diagram
        // both last are matching then m - 1 and n - 1
        // if not matching then will have two choices m - 1:n, n - 1:m

        if(x.charAt(n - 1) == y.charAt(m - 1)) {

            // we got one common character
            t[n][m] = 1 + longestCommonSubsequence(x, y, n - 1, m - 1);

        } else {
            // here two choices if it does not match then consider from one
            // and in second consider from second and take maximum from them
            // from input h != r, but it can be possible in other index that is why

            t[n][m] =  Math.max(longestCommonSubsequence(x, y, n, m - 1),
                    longestCommonSubsequence(x, y, n - 1, m));
        }

        return t[n][m];

    }


    private static Integer longestCommonSubsequence(String x, String y, int n, int m) {

        // base condition
        // the smallest input will be x = "", y = ""

        if (n == 0 || m == 0) {
            return 0;
        }

        // choice diagram
        // both last are matching then m - 1 and n - 1
        // if not matching then will have two choices m - 1:n, n - 1:m

        if(x.charAt(n - 1) == y.charAt(m - 1)) {

            // we got one common character
            return 1 + longestCommonSubsequence(x, y, n - 1, m - 1);

        } else {
            // here two choices if it does not match then consider from one
            // and in second consider from second and take maximum from them
            // from input h != r, but it can be possible in other index that is why

            return Math.max(longestCommonSubsequence(x, y, n, m - 1),
                    longestCommonSubsequence(x, y, n - 1, m));
        }


    }
}
