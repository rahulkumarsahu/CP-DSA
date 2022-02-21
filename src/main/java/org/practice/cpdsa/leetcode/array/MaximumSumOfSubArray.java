package org.practice.cpdsa.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumOfSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,1,8,2,9,1};
        int[] arr1 = new int[]{12, -1, -7, 8, -15, 30, 18, 28};
        int target = 3;
        int output = maximumSumOfSubArray(arr, target, arr.length);
        System.out.println(output);
        List<Integer> result = firstNegativeNumber(arr1, target, arr.length);
        System.out.println(result);
    }
//

    private static List<Integer> firstNegativeNumber(int[] arr, int target, int n) {
        // total output = size - k + 1
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();

        while(j < n) {
            if(arr[j] < 0) {
                result.add(arr[j]);
            }
            if(j - i + 1 < target) {
                j++;
            } else if(j - i + 1 == target)  {
                if(result.isEmpty()) {
                    System.out.print(" " + 0);
                } else {
                    System.out.print(" " + result.get(0));
                    if(result.get(0) == arr[i]) {
                        result.remove(result.get(0));
                    }
                }
                i++;
                j++;
            }
        }
        return result;
    }
    private static int maximumSumOfSubArray(int[] arr, int target, int n) {
         int j = 0;
         int i = 0;
         int answer = 0;
         int sum = 0;
         // to run the loop when j reaches till end
         while(j < n) {
             // window size calculation = j - i + 1
             // increase j till the window size
             sum += arr[j];
             if (j - i + 1 < target) {
                 j++;
             } else if(j - i + 1 == target) {
                 answer = Math.max(answer, sum);
                 sum -= arr[i];
                 i++;
                 j++;
             }

         }
         return answer;
    }
}

