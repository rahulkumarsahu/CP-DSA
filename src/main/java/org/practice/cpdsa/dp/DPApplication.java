package org.practice.cpdsa.dp;


public class DPApplication {

    public static void main(String[] args) {

      System.out.println(maxRepeating("ababc", "ac"));

      int output = message("Abfd@3#c");
      System.out.println(output);
      int result = subString("1111111", 7);
      System.out.println(result);
    }

    public static int subString(String s, int n) {

        int result = 0;
        
        for (int i = 0; i < n; i++)
            for (int len = 1; len <= n-i; len++)
                if (checkEquality(s.substring(i, i + len)))
                    result++;

        return result;
    }

    private static boolean checkEquality(String s) {

        return (s.charAt(0) != s.charAt(s.length() - 1));
    }

    private static int message(String s) {

        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch) && Character.isUpperCase(ch)) {
                count += 2;
            } else if(Character.isAlphabetic(ch) && Character.isLowerCase(ch)) {
                count += 1;
            }
        }

        return count;
    }


    public static int maxRepeating(String sequence, String word) {
        int ans = 1;
        // while (sequence.indexOf(word.repeat(ans)) >= 0)
        while (sequence.contains(word.repeat(ans)))
            ++ans;
        return ans - 1;
    }


}
// 10, 02, 12, 20, 10, 01, 21, 01