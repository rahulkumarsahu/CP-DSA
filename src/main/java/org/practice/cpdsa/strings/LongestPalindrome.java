package org.practice.cpdsa.strings;
// https://www.youtube.com/watch?v=AKIHWGumagI
public class LongestPalindrome {

    public static void main(String[] args) {
        String input = "aaaabbaa";
        String output = findLongestPalindrome(input);
        System.out.println(output);

    }

    private static String findLongestPalindrome(String input) {

        int start = 0;
        int end = 1;
        int low;
        int high;

        for(int i = 1; i < input.length(); i++) {

            low = i - 1;
            high = i;

            while (low >= 0 && high < input.length() && input.charAt(high) == input.charAt(low)) {
                if (high - low + 1 > end) {
                    start = low;
                    end = high - low + 1;
                }
                low--;
                high++;
            }

            low = i - 1;
            high = i + 1;

            while (low >= 0 && high < input.length() && input.charAt(high) == input.charAt(low)) {
                if (high - low + 1 > end) {
                    start = low;
                    end = high - low + 1;
                }
                low--;
                high++;
            }

        }
        return input.substring(start, start + end);
    }
}
