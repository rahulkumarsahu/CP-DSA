package org.practice.cpdsa;

import org.practice.cpdsa.sorting.Helper;

import java.util.*;

public class Testing {

    public static void main(String[] args) {
        /**
        int[] output = maxSubsequence(new int[]{-1,-2,3,4}, 3);
        Helper.print(output);
         **/
        List<int[]> output = getAllPossibleCombination(new int[]{1, 3, 2, -1, 4, 1, 7, 1}, 4);

        output.forEach(key -> {
            System.out.println(key[0] + " " + key[1]);
        });


    }

    static int findSubarraySum(int arr[], int n, int sum) {

        HashMap<Integer, Integer> prevSum = new HashMap<>();
        prevSum.put(0,1);

        int res = 0;

        int currSum = 0;

        for (int i = 0; i < n; i++) {

            currSum += arr[i];
            //calculate the sum that have to be removed
            //so that we can get the desired sum

            int removeSum = currSum - sum;

            //get count of occurrences of that sum that
            //have to removed and add it to res value
            if (prevSum.containsKey(removeSum))
                res += prevSum.get(removeSum);

            // Add current sum value to count of
            // different values of sum.
            prevSum.put(currSum, prevSum.getOrDefault(currSum,0) + 1);
        }

        return res;
    }

    private static List<int[]> getAllPossibleCombination(int[] arr, int sum) {


        int i = 0;
        int j = 0;

        int length = arr.length;
        List<int[]> outputList = new ArrayList<>();
        int data = 0;

        while( j < length) {

            data += arr[j];

            if(data == sum) {
                outputList.add(new int[]{i, j});
            } else if(data > sum) {

                while(i < j) {
                    data -= arr[i];
                    i++;
                    if(data == sum) {
                        outputList.add(new int[]{i, j});
                    }
                }
            }

            j++;
        }

        return outputList;

    }

    public static int[] maxSubsequence(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : pq) {
            freq.merge(n, 1, Integer::sum);
        }
        int[] seq = new int[k];
        int i = 0;
        for (int n : nums) {
            if (freq.merge(n, -1, Integer::sum) >= 0) {
                seq[i++] = n;
            }
        }
        return seq;

        /**

        int i = 0;
        int j = 0;

        int sum = 0;
        int output = Integer.MIN_VALUE;

        int[] arr = new int[k];
        int[] arr1 = new int[2];

        while(j < nums.length) {

            sum = sum + nums[j];

            // window size
            if(j - i + 1 == k && output < sum) {

                arr1[0] = i;
                arr1[1] = j;
                output = sum;

            } else if(j - i + 1 > k) {

                sum = sum - nums[i];
                i++;

                if(output < sum) {
                    arr1[0] = i;
                    arr1[1] = j;
                    output = sum;
                }
            }

            j++;
        }

        int m = 0;
        for(int l = arr1[0]; l <= arr1[1]; l++) {
            arr[m] = nums[l];
            m++;
        }

        return arr;

         **/

    }
}
