package org.practice.cpdsa.array.miscellaneous;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        // left pointer, right pointer...
        int left = 0;
        int right = height.length - 1;

        int max = 0;

        while(left < right) {
            // we have to calculate the maximum water containing between polls
            // take the minimum in between left poll and right poll because height of water is possible the height of min poll
            // and multiply with difference of index to get the containing water.
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            // if both value is equal then move both pointer
            if(height[left] == height[right]) {
                left++;
                right--;
            } else if(height[left] < height[right]) {
                // if left is min then move left pointer to get maximum
                left++;
            } else {
                // if right is min then move right pointer to get maximum
                right--;
            }
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
