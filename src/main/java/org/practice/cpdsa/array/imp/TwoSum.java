package org.practice.cpdsa.array.imp;

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
        threeSum(numArray, target);
        System.out.println("The third Maximum number is :- " + Arrays.toString(output));
        scanner.close();
    }
    // sort the array
    // apply two pointer
    private static int threeSum(int[] numArray, int target) {
        Arrays.sort(numArray);

        for(int i = 0; i < numArray.length; i++) {
            int low = i + 1; // this is first pointer and pointing to 1 th index
            // this is second pointer pointing to last element
            int high = numArray.length - 1;
            // here a + b + c = target
            // so considering A as constant and finding b and c
            int sum = target - numArray[i];
            while (low < high) {
                // found the sum
                if(numArray[low] + numArray[high] == sum) {
                    return 1;
                } else if (numArray[low] + numArray[high] > sum) {
                    // if sum is going greater than low + high value then high -- to get the low value
                    high--;
                } else if (numArray[low] + numArray[high] < sum) {
                    low++;
                }
            }
        }
        return 0;
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
