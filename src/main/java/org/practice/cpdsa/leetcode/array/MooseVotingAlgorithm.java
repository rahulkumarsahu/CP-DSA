package org.practice.cpdsa.leetcode.array;

import java.util.Arrays;
// https://www.youtube.com/watch?v=NgLeC7DeWn4
public class MooseVotingAlgorithm {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
        // N/2 -> only one majority
        int output = majorityElement(arr, arr.length);
        // N/3 -> only two majority element
        int[] data = majorityElementTwo(arr);
        System.out.println(output);
        System.out.println(Arrays.toString(data));
    }

    private static int[] majorityElementTwo(int[] arr) {
        int majorityElement1 = -1;
        int majorityElement2 = -1;
        int counter1 = 0;
        int counter2 = 0;

        for(int data : arr) {

            // here to find majority element we can consider 1st unique one as majority element 1 and 2nd unique as majority element 2
            // when arr[i] matches to which ever majority element counter increases
            // when no matches then reduce both counter...
            if(majorityElement1 == data) counter1++;
            else if(majorityElement2 == data) counter2++;
            else if(counter1 == 0) {
                majorityElement1 = data;
                counter1++;
            } else if(counter2 == 0) {
                majorityElement2 = data;
                counter2++;
            } else {
                counter1--;
                counter2--;
            }

        }
        // before returning it is > N/3 are not if not do not return
        return new int[]{majorityElement1, majorityElement2};
    }

    // this algorithm says that maintain majorityElement
    // when count == 0 then assign the majorityElement to arr[i]
    // increase votingCount when arr[i] matches the majorityElement
    // decrease the majority element when it does not match
    private static int majorityElement(int[] arr, int n) {
        // 1st step
        int majorityElementIndex = 0;
        int votingCount = 1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[majorityElementIndex] == arr[i]) {
                votingCount++;
            } else {
                votingCount--;
            }

            if (votingCount == 0) {
                votingCount = 1;
                majorityElementIndex = i;
            }

        }

        votingCount = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[majorityElementIndex] == arr[i]) {
                votingCount++;
            }
        }

        if(votingCount <= n/2) {
            return -1;
        } else {
            return arr[majorityElementIndex];
        }

    }
}
