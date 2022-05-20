package org.practice.cpdsa.array.important;

import java.util.Arrays;
//O(N)
public class DutchNationalFlagAlgorithm {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,0,1,2,1,2,0,0,0,1};
        int[] output = sortArray(arr);
        System.out.println(Arrays.toString(output));
    }
    // this algorithm says that we should take 3 pointer
    // start = 0
    // mid = 0
    // end = length - 1
    // if mid == 0 and start != mid then swap mid and start and increment both
    // if mid == 1 then mid++
    // if mid == 2 then swap mid and end and decrement high but not mid because mid got new value and action can be taken from that.
    private static int[] sortArray(int[] arr) {
        int startIndex = 0;
        int midIndex = 0;
        int endIndex = arr.length - 1;

        while(midIndex <= endIndex) {

            if(arr[midIndex] == 0) {

                if(startIndex != midIndex) {
                    int temp = arr[startIndex];
                    arr[startIndex] = arr[midIndex];
                    arr[midIndex] = temp;
                }
                startIndex++;
                midIndex++;
            } else if(arr[midIndex] == 1) {
                midIndex++;
            } else if(arr[midIndex] == 2) {
                if(endIndex != midIndex) {
                    int temp = arr[endIndex];
                    arr[endIndex] = arr[midIndex];
                    arr[midIndex] = temp;
                }
                endIndex--;
            }

        }
        return arr;
    }


}
