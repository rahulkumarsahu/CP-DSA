package org.practice.cpdsa.strings;

import org.practice.cpdsa.sorting.Helper;

public class LongestUniformSubstring {

    public static void main(String[] args) {
        int[] output = longestUniformSubstring("abbbccda");
        Helper.print(output);

        // implement your atoi
        // result = result * 10 + input.charAt(i) - '0'
        // so here we are subtracting from ASCII 0 value to charAt(i) to get exact number and adding to result * 10;
        // first non repeating character use hashmap for
    }

    private static int[] longestUniformSubstring(String input) {
        // define index = -1;
        int index = -1;
        // define length to return
        int length = 0;
        // take one counter
        int counter = 1;
        //
        int i;

        // if length == 0 then return -1 and 0
        if(input.length() == 0) return new int[]{-1, 0};
        // if length == 1 then return 1 and 0
        if(input.length() == 1) return new int[]{1, 0};
        // start from 1 till length
        for(i = 1; i < input.length(); i++) {
           // if i == i - 1 index value...
            if(input.charAt(i) == input.charAt(i - 1)) {
                // increase counter
                counter++;
            } else {
                // so initially counter will be 1 and after that when we found continuous duplicate counter will be keep on increasing
                // when counter > length, so we have to find index
                // length will be == counter
                // index = i - counter example abbbccda if i is in 4 index then counter will be 3 || 4 - 3 = 1
                if(counter > length) {
                    length = counter;
                    index = i - counter;
                }
                counter = 1;
            }
        }

        if(counter > length) {
            length = counter;
            index = i - counter;
        }
        return new int[]{index, length};
    }
}
