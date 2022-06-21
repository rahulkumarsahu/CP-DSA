package org.practice.cpdsa.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestKUniqueCharactersSubstring {

    public static void main(String[] args) {
        int out = longestSubString("aaabb", 3);
        System.out.println(out);
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
                    j++;
                }
            }

        }

        return answer;
    }
}
