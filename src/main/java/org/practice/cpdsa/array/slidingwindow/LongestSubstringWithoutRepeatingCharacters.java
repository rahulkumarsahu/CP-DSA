package org.practice.cpdsa.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int i = 0;
        int j = 0;

        int max = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(j < s.length()) {

            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            // j - i + 1 why? we want max sub array with all unique character. so, it will depend on window size.
            if(map.size() == j - i + 1) {
                max = Math.max(max, j - i + 1);
            } else if(map.size() < j - i + 1) {
                while(map.size() < j - i + 1) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }

            j++;
        }

        return max;

    }

    public int lengthOfLongestSubstring1(String s) {


        int i = 0;
        int j = 0;

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        while(j < s.length()) {

            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while(map.get(s.charAt(j)) > 1) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }

            max = Math.max(max, j - i + 1);

            j++;
        }

        return max;
    }

}
