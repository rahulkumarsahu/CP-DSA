package org.practice.cpdsa.array.slidingwindow;

import java.util.*;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

            Map<Character, Integer> map = new HashMap<>();

            for(int i = 0; i < t.length(); i++) {
                map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
            }

            int i = 0;
            int j = 0;
            int count = map.size();
            int minimumI = 0;
            int minimumJ = 0;
            int minimum = Integer.MAX_VALUE;

            while(j < s.length()) {
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    if (map.get(s.charAt(j)) == 0)
                        count--;
                }
                if (count > 0) {
                }
                else {
                    while (count == 0) {
                        if (minimum > j - i + 1) {
                            minimum = j - i + 1;
                            minimumI = i;
                            minimumJ = j + 1;
                        }
                        if(map.containsKey(s.charAt(i))) {
                            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                            if(map.get(s.charAt(i))== 1)
                                count++;
                        }
                        i++;
                    }
                }
                j++;
            }
            return s.substring(minimumI, minimumJ);
        }
}
