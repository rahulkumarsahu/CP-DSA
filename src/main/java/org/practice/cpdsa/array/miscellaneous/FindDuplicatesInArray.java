package org.practice.cpdsa.array.miscellaneous;

import java.util.*;

public class FindDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> data = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            // first find the index - 1 because of 1 to N range
            int index = Math.abs(nums[i]) - 1;
            // check the index value is visited or not if visited already and make -ve
            // and only max 2 freq will be there according to question
            if(nums[index] < 0) data.add(Math.abs(nums[i]));
            // make the index value as -ve as visited.
            nums[index] = -nums[index];
        }

        return data;

    }
}
