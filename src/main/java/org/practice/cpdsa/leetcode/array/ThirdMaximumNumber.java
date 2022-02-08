package org.practice.cpdsa.leetcode.array;

import java.util.*;


public class ThirdMaximumNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The size of array :- ");
        int size = scanner.nextInt();
        int[] numArray = new int[size];
        System.out.println("Enter The elements of array :- ");
        for(int i = 0; i < size; i++) {
            numArray[i] = scanner.nextInt();
        }
        int thirdMax = findThirdMaximum(numArray);
        int secondWayThirdMax = findSecondWayThirdMax(numArray);
        System.out.println("The third Maximum number is :- " + thirdMax);
        System.out.println("The third Maximum number is :- " + secondWayThirdMax);
        scanner.close();

    }

    private static int findSecondWayThirdMax(int[] nums) {

        Integer max = null;
        Integer secondMax = null;
        Integer thirdMax = null;

        for(Integer num : nums) {

            if(num.equals(max) || num.equals(secondMax) || num.equals(thirdMax)) continue;

            if(max == null || num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if (secondMax == null || num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if(thirdMax == null || num > thirdMax) {
                thirdMax = num;
            }
        }

        return thirdMax == null ? max : thirdMax;
    }


    // time complexity is O(n + n) = O(2n)
    private static int findThirdMaximum(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for (int data : nums) {
            numSet.add(data);
        }

        int max = nums[0];
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int num : numSet) {

            if((num == max || num == secondMax || num == thirdMax))
                continue;

            if(num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if(num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if(num > thirdMax) {
                thirdMax = num;
            }
        }


        if(numSet.size() <= 2)
            return max;

        return thirdMax;
    }

}