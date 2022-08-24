package org.practice.cpdsa.array.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MaximumFromAllSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int target = 3;

        List<Integer> result = maximumFromSubArray(arr, target, arr.length);
        System.out.println(result);
    }


    private static List<Integer> maximumFromSubArray(int[] arr, int target, int length) {

        List<Integer> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        int i = 0;
        int j = 0;


        while (j < length) {

            int size = result.size();
            // if data comes add it on the list and if current value is maximum then lesser values will get remove from result list.
            while(!result.isEmpty() && result.get(size - 1) < arr[j]) {
                result.remove(size - 1);
                size--;
            }
            result.add(arr[j]);

            if(j - i + 1 < target) {
                j++;
            } else if (j - i + 1 == target) {

                // if we got our window then add 0 index element into output and if arr[i] matches to head value of list
                // then remove the head element to clear previous data because next window arr[i] will not be part of window
                int data = result.get(0);
                output.add(data);
                // data == current removing element from sliding window then only remove otherwise let it be.
                if (data == arr[i]) {
                    result.remove(0);
                }
                i++;
                j++;
            }
        }

        return output;
    }
}
