package org.practice.cpdsa.leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class MostBookedHotelRoom {

    public static void main(String[] args) {
        String[] books1 = { "+1A", "+3E", "-1A", "+4F", "+1A", "-3E", "+1A", "-1A", "+1A" };
        String[] books2 = {"+1E", "-1E", "+1E", "-1E", "+1E", "-1E", "+1E", "-1E","+2A", "-2A", "+2A", "-2A", "+2A", "-2A", "+2A",
                "-2A","+2B", "-2B", "+2B", "-2B", "+2B", "-2B", "+2B", "-2B"};
        System.out.println(solution(books1));
        System.out.println(solution(books2));
    }

    private static String solution(String[] rooms) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for(String room : rooms) {
            String cur = room.substring(1);
            if(room.charAt(0) == '+') {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                max= Math.max(max, map.get(cur));
            }
        }
        String minstring = "9Z";
        for(String room : rooms) {
            String cur  = room.substring(1);
            if(map.get(cur) == max && isSmaller(cur, minstring)) {
                    minstring = cur;
            }
        }
        return max > 0 ? minstring : null;
    }

    public static boolean isSmaller(String a, String b) {
        if (a.equals(b))
            return true;
        int numa = (a.charAt(0) - '0');
        int numb = (b.charAt(0) - '0');
        if (numa < numb)
            return true;
        else if (numa > numb)
            return false;
        else {
            char ca = a.charAt(a.length() - 1);
            char cb = b.charAt(b.length() - 1);
            return ca <= cb;
        }
    }

    }
