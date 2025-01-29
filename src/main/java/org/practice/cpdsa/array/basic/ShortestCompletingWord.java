package org.practice.cpdsa.array.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/shortest-completing-word/?envType=problem-list-v2&envId=array
public class ShortestCompletingWord {

    public static void main(String[] args) {

        String output = shortestCompletingWord("1s3 PSt", new String[]{"step","steps","stripe","stepple"});
        System.out.println(output);

    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {

        // holds the char count from licensePlate
        int[] charCount = new int[26];

        // holds the possible output
        List<String> output = new ArrayList<>();

        // Add char count for each character in char count array.
        for (Character c : licensePlate.toCharArray()) {
            if (isChar(c)) {
                // here converting the char first and then
                charCount[Character.toLowerCase(c) - 'a']++;
            }
        }

        return "output";
    }

    private static boolean isChar(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }
}


