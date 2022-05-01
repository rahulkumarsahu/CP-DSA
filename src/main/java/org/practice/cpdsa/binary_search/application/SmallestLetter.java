package org.practice.cpdsa.binary_search.application;

import java.util.ArrayList;
import java.util.List;

public class SmallestLetter {

    public static void main(String[] args) {
        char[] arr = new char[]{'e','e','e','e','n','n','n'};
        char ch = 'e';
        char output = smallestLetter(arr, ch);
        System.out.println(output);

    }

    public static char smallestLetter(char[] arr, char ch) {

        List<Character> numSet = new ArrayList<>();

        for (char data : arr) {
            if(Boolean.FALSE.equals(numSet.contains(data))) {
                numSet.add(data);
            }
        }

        int startIndex = 0;
        int endIndex = numSet.size() - 1;

        if(ch >= numSet.get(endIndex)) {
            return numSet.get(0);
        }

        while (startIndex <= endIndex) {

            int midIndex = startIndex + (endIndex - startIndex) / 2;
            // if exact match is there then return index + 1;
            if(ch == numSet.get(midIndex) && midIndex != numSet.size() - 1) {

                return numSet.get(midIndex + 1);
            } else if(ch >= numSet.get(midIndex)) {

                startIndex = midIndex + 1;
            } else {

                endIndex = midIndex - 1;
            }
        }

        return numSet.get(startIndex);
    }
     // same for ciel and floor also same code as binary search
    // for ceil return startIndex
    // for floor return endIndex

}

