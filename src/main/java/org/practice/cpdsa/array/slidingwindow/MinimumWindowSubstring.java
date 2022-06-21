package org.practice.cpdsa.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

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
}
