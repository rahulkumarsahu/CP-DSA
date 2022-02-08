package org.practice.cpdsa.leetcode.array;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The size of array :- ");
        int size = scanner.nextInt();
        System.out.print("Enter The target :- ");
        int target = scanner.nextInt();
        int[] numArray = new int[size];
        System.out.println("Enter The elements of array :- ");
        for(int i = 0; i < size; i++) {
            numArray[i] = scanner.nextInt();
        }
        int[] output = twoSum(numArray, target);
        System.out.println("The third Maximum number is :- " + Arrays.toString(output));
        scanner.close();
    }

    private static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();
        int[] output = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(numMap.containsKey(diff)) {
                output[0] = numMap.get(diff);
                output[1] = i;
                break;
            } else {
                numMap.put(nums[i], i);
            }
        }

        return output;
    }
}
