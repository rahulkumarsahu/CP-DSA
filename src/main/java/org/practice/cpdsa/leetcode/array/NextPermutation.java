package org.practice.cpdsa.leetcode.array;

import org.practice.cpdsa.sorting.Helper;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 1};
        nextPermutation(input);
        Helper.print(input);
    }
    //1 2 4
    //1 4 2
    //2 1 4
    //2 4 1
    //4 1 2
    //4 2 1
    // 1 -> input[i] < input[i+1] -> iterate from last and check the point where you got the i < i + 1
    // 2 -> start from end and move the pointer till you find the greater element from above i index
    // 3 -> swap both the value
    // 4 -> reverse the all value after swapping
    private static void nextPermutation(int[] input) {
        int i;
        int j;

        for(i = input.length - 2; i > 0; i--) {
            if(input[i] < input[i+1]) break;
        }

        for(j = input.length - 1; j > 0; j--) {
            if(input[j] > input[i]) break;
        }

       Helper.swap(input, i, j);

        Arrays.sort(input, j != 0 ? j - 1 : 0, input.length);

    }
}
