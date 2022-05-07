package org.practice.cpdsa.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5
public class CountOccurrencesOfAnagram {

    public static void main(String[] args) {

        int subString = countOccurrencesOfAnagram("forabcdrofijklorf", "for");
        System.out.println(subString);
    }

    private static int countOccurrencesOfAnagram(String s1, String s2) {
        // string s2 is the pattern which we have to check in s1 we find anagram or not.
        Map<Character, Integer> patternFreqMap = new HashMap<>();
        // window size
        int k = s2.length();
        int n = s1.length();
        for(int i = 0; i < k; i++) {
            // store the frequency of each character from pattern string
            patternFreqMap.put(s2.charAt(i), patternFreqMap.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;
        // if frequency is becoming zero reduce count.
        int count = patternFreqMap.size();
        int result = 0;

        while (j < n) {

            // calculation -> if we are getting the character matching with pattern then we have to reduce the count
            // and, we have to reduce frequency as well as count
            if(patternFreqMap.containsKey(s1.charAt(j))) {
                patternFreqMap.put(s1.charAt(j), patternFreqMap.get(s1.charAt(j)) - 1);
                if(patternFreqMap.get(s1.charAt(j)) == 0) {
                    count--;
                }
            }

            // if < window size increment j++;
            if(j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // if equal to window size
                if(count == 0) {
                    result++;
                }
                // now we have to move the window so before moving we have to remove the previous one calculation which is i
                // so for that, if in new window we found a character which is already present in map then increase the count in the pattern map
                // and, increment the counter also if frequency is 0 because we are decreasing counter when frequency is 0.
                if(patternFreqMap.containsKey(s1.charAt(i))) {
                    if(patternFreqMap.get(s1.charAt(i)) == 0) count++;
                    patternFreqMap.put(s1.charAt(i), patternFreqMap.get(s1.charAt(i)) + 1);
                }
                j++;
                i++;
            }
        }
        return result;
    }
}
