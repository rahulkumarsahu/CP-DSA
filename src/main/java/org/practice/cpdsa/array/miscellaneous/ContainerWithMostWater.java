package org.practice.cpdsa.array.miscellaneous;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {


        int left = 0;
        int right = height.length - 1;

        int max = 0;

        while(left < right) {

            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            if(height[left] == height[right]) {
                left++;
                right--;
            } else if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;

    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
