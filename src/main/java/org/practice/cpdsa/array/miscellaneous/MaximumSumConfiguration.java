package org.practice.cpdsa.array.miscellaneous;

public class MaximumSumConfiguration {

    public int max_sum(int[] arr, int n) {

        int indexSum = 0;
        int sum = 0;

        int maxSum = 0;

        for(int i = 0; i < n; i++) {

            indexSum += (arr[i] * i);
            sum += arr[i];

        }

        for(int i = 0; i < n; i++) {

            int currentSum = indexSum + sum - n * arr[n - i - 1];

            if(currentSum > maxSum) {
                maxSum = currentSum;
            }

            indexSum = currentSum;

        }

        return maxSum;

    }
}
