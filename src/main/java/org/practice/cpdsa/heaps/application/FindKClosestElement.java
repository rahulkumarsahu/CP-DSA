package org.practice.cpdsa.heaps.application;

import java.util.*;

public class FindKClosestElement {

    public static List<Integer> findKClosestElements(List<Integer> input, int k, int target) {
        // binary search
        int i = Collections.binarySearch(input, target);
        // to return lower bound
        if (i < 0) {
            i = -(i + 1);
        }

        int left = i - 1;
        int right = i;

        while (k-- > 0) {

            if (left < 0 || (right < input.size() &&
                    Math.abs(input.get(left) - target) > Math.abs(input.get(right) - target))) {
                right++;
            }
            else {
                left--;
            }
        }

        return input.subList(left + 1, right);
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 12, 15, 17, 18, 20, 25);
        int target = 16, k = 4;

        System.out.println(findKClosestElements(input, k, target));
    }
}
