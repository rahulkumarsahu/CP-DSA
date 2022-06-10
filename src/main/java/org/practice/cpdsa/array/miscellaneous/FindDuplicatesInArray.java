package org.practice.cpdsa.array.miscellaneous;

import java.util.*;

public class FindDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> data = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            // to find the index
            int index = Math.abs(nums[i]) - 1;

            if(nums[index] < 0) data.add(Math.abs(nums[i]));

            nums[index] = -nums[index];
        }

        return data;

    }
}
