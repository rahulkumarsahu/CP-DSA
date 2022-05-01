package org.practice.cpdsa.array;

public class MaximumSumPathInTwoSortedArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 7, 10, 12};
        int[] arr2 = new int[]{1, 5, 7, 8};

        int output = maximumSumPathInTwoSortedArray(arr1, arr2);

        System.out.println(output);

    }

    private static int maximumSumPathInTwoSortedArray(int[] arr1, int[] arr2) {

        int m = arr1.length;
        int n = arr2.length;

        int sum1 = 0;
        int sum2 = 0;
        int result = 0;

        int i = 0;
        int j = 0;

        while (i < m && j < n) {

            if(arr1[i] < arr2[j]) {
                sum1 += arr1[i++];
            }else if(arr1[i] > arr2[j]) {
                sum2 += arr2[j++];
            } else if(arr1[i] == arr2[j]) {
                result += Math.max(sum1, sum2) + arr1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

        while (i < m) {
            sum1 += arr1[i++];
        }

        while (j < n) {
            sum2 += arr1[j++];
        }

        result += Math.max(sum1, sum2);

        return result;
    }
}
