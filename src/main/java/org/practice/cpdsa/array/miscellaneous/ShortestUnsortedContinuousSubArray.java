package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubArray {

    public int findUnsortedSubArray(int[] nums) {

        int[] sortArray = new int[nums.length];

        System.arraycopy(nums, 0, sortArray, 0, nums.length);

        Arrays.sort(sortArray);

        if(nums.length == 1) return 0;

        int startPointer = -1;
        int endPointer = -1;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == sortArray[i]) continue;

            if(startPointer == -1) {
                startPointer = i;
            } else {
                endPointer = i;
            }

        }

        return startPointer == -1 ? 0 : endPointer - startPointer + 1;
    }

    public int findUnsortedSubArray2(int[] nums) {

        int startPointer = 0;
        int endPointer = nums.length - 1;
        // 2,6,4,8,10,9,15
        // find the start pointer by checking current element <= + 1 element
        // till when condition is matching it will keep on incrementing the start pointer and after that loop will break when condition fails
        while(startPointer + 1 < nums.length && nums[startPointer] <= nums[startPointer + 1]) {
            startPointer++;
        }
        // same as above explanation
        while(endPointer - 1 >= 0 && nums[endPointer - 1] <= nums[endPointer]) {
            endPointer--;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if(startPointer == nums.length - 1) return 0;

        for(int k = startPointer; k <= endPointer; k++) {
            min = Math.min(min, nums[k]);
            max = Math.max(max, nums[k]);
        }

        // corner case + till when start pointer is > min
        while(startPointer - 1 >= 0 && nums[startPointer - 1] > min) startPointer--;
        // // corner case + till when end pointer is < max
        while(endPointer + 1 <= nums.length - 1 && nums[endPointer + 1] < max) endPointer++;


        return endPointer - startPointer + 1;
    }
}
