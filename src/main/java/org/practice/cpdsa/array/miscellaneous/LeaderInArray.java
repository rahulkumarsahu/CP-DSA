package org.practice.cpdsa.array.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class LeaderInArray {

    static ArrayList<Integer> leaders(int[] arr, int n) {

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length - 1]);

        for(int i = arr.length - 2; i >= 0; i--) {

            if(arr[i] >= stack.peek()) {
                stack.push(arr[i]);
            }
        }

        return (ArrayList<Integer>) stack.stream().sorted(Collections.reverseOrder()).toList();
    }


}
