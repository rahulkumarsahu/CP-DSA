package org.practice.cpdsa.array.slidingwindow;

public class LongestSubArraySumK {

    public static int lenOfLongSubArray (int[] arr, int n, int sum) {

        int maxWindow = 0;
        int i = 0;
        int j = 0;

        int arrSum = 0;

        while(j < n) {

            arrSum += arr[j];

            if(arrSum < sum) j++;
            else if(sum == arrSum) {

                maxWindow = Math.max(maxWindow, j - i + 1);
                j++;
            } else {

                while(arrSum > sum) {
                    arrSum -= arr[i];
                    i++;
                }

                if(sum == arrSum){
                    maxWindow = Math.max(maxWindow, j - i + 1);
                }

                j++;
            }
        }

        return maxWindow;

    }
}
