package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;

public class LargestPerimeterTriangle {

    /**
     * We sort the A
     * Try to get a triangle with 3 biggest numbers.
     * If A[n-1] < A[n-2] + A[n-3], we get a triangle.
     * If A[n-1] >= A[n-2] + A[n-3] >= A[i] + A[j], we cannot get any triangle with A[n-1]
     * repeat step2 and step3 with the left numbers.
     */
    public int largestPerimeter(int[] nums) {

        Arrays.sort(nums);

        for(int i = nums.length - 3; i >= 0; i--) {
            if(nums[i] + nums[i + 1] > nums[i + 2])
                return nums[i] + nums[i + 1] + nums[i + 2];
        }

        return 0;

    }
}
