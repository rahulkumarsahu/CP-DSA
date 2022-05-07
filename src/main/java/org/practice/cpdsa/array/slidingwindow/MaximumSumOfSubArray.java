package org.practice.cpdsa.array.slidingwindow;

import java.util.*;

public class MaximumSumOfSubArray {

    public static void main(String[] args) {


        // Longest Substring With Without Repeating Characters
        int data = longestSubStringWithUniqueCharacter();
        System.out.println(data);

        int out = longestSubString("aaabb", 3);
        System.out.println(out);
        int subString = minimumWindowSubstring("time to practice", "toc");
        System.out.println(subString);
    }

    private static int minimumWindowSubstring(String string, String target) {
        int i = 0;
        int j = 0;
        char[] ch = string.toCharArray();
        Map<Character, Integer > charMap = new HashMap<>();
        int count = target.length();
        for(int k = 0; k < target.length(); k++) {
            charMap.put(target.charAt(k), charMap.getOrDefault(target.charAt(k), 0) + 1);
        }
        int answer = -1;
        int length = ch.length;
        while (j < length) {

            if(charMap.containsKey(ch[j])) {
                charMap.put(ch[j], charMap.get(ch[j]) - 1);
                if(charMap.get(ch[j]) <= 0) count--;
                j++;
            } else if (count == 0) {
                answer = Math.max(answer, j - i + 1);
            }


        }
        return answer;
    }

    private static int longestSubString(String str, int target) {
        int i = 0;
        int j = 0;
        char[] ch = str.toCharArray();
        Map<Character, Integer > charMap = new HashMap<>();
        int answer = -1;
        int length = ch.length;
        while (j < length) {

            charMap.put(ch[j], charMap.getOrDefault(ch[j], 0) + 1);

            if(charMap.size() < target) {
                j++;
            } else if (charMap.size() == target) {
                answer = Math.max(answer, j - i + 1);
                j++;
            } else {
                while (charMap.size() > target) {
                    charMap.put(ch[i],  charMap.get(ch[i]) - 1);
                    if(charMap.get(ch[i]) == 0) {
                        charMap.remove(ch[i]);
                    }
                    i++;
                }
            }

            j++;

        }

        return answer;
    }

    private static int longestSubStringWithUniqueCharacter() {
        int i = 0;
        int j = 0;
        char[] ch = "meayl".toCharArray();
        Map<Character, Integer > charMap = new HashMap<>();
        int answer = -1;
        int length = ch.length;
        while (j < length) {

            charMap.put(ch[j], charMap.getOrDefault(ch[j], 0) + 1);
           // j - i + 1 why? we want max sub array with all unique character. so, it will depend on window size.
           if(charMap.size() == j - i + 1) {
                answer = Math.max(answer, j - i + 1);
            } else if(charMap.size() < j - i + 1) {
                while (charMap.size() < j - i + 1) {
                    charMap.put(ch[i],  charMap.get(ch[i]) - 1);
                    if(charMap.get(ch[i]) == 0) {
                        charMap.remove(ch[i]);
                    }
                    i++;
                }
            }

           j++;

        }

        return answer;
    }
}

