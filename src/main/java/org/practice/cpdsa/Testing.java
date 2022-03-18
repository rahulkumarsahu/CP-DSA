package org.practice.cpdsa;

import org.practice.cpdsa.sorting.Helper;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Testing {

    public static void main(String[] args) {

        int[] output = maxSubsequence(new int[]{-1,-2,3,4}, 3);
        Helper.print(output);

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
