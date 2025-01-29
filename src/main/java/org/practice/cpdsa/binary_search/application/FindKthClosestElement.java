package org.practice.cpdsa.binary_search.application;

import java.util.ArrayList;
import java.util.Collections;

public class FindKthClosestElement {

    public static void main(String[] args) {
        int[] arr = new int[]{10,20,30,40,50};
        int target = 45;
        int k = 3;
        ArrayList<Integer> output = findKthClosestElement(arr, k, target);
        output.forEach(System.out::println);

    }

    /**
     * Here we have to find kth closest element we have given a K ex. 3 and target is 45
     * for the array = [10,20,30,40,50] so we have to find 3 closest element to 45
     * so, we will apply binary search to reach the closest position of the target and
     * then we have startIndex and endIndex and we will try to find kth closest element
     * so for that we should have to take two pointers left and right,
     *
     * so left we will assign to endIndex and right we will assign it to startIndex
     * why? because binary search breaks when endIndex cross startIndex so end will be left side and
     * start will be right side.
     *
     * and we have to handle some corner cases like
     * if left crosses 0 index and right crosses out of length index
     * and k > 0 so till then loop will continue and,
     * we will take difference and in output list we will add the smaller value and move the pointer accordingly
     *
     * and suppose one case if left crosses 0 index but k is still > 0 then we have to add all right side element
     * right?
     * and similarly vice-versa
     * @param arr
     * @param k
     * @param target
     * @return
     */
    private static ArrayList<Integer> findKthClosestElement(int[] arr, int k, int target) {

        int length = arr.length;
        int startIndex = 0;
        int endIndex = length - 1;
        int midIndex = 0;

        while(startIndex <= endIndex) {

            midIndex = startIndex + (endIndex - startIndex) / 2;

            if(arr[midIndex] == target) {
                break;
            } else if (arr[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // e = 3, s = 4 // if issue comes then left = midIndex - 1, right = midIndex
        int left = endIndex;
        int right = startIndex;

        while (left >= 0 && right < length && k > 0) {

            if(Math.abs(arr[left] - target) <= Math.abs(arr[right] - target)) {
                result.add(arr[left]);
                left--;
            } else {
                result.add(arr[right]);
                right++;
            }
            k--;
        }

        while (k > 0 && left >= 0) {
            result.add(arr[left]);
            left--;
            k--;
        }

        while (k > 0 && right < length) {
            result.add(arr[right]);
            right++;
            k--;
        }


        Collections.sort(result);

        return result;
    }
}
