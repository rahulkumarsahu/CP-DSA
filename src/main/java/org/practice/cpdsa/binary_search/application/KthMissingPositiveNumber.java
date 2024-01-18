package org.practice.cpdsa.binary_search.application;
//1539
public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int out = findKthPositiveBruteForceApproach(new int[]{2,3,4,7,11}, 5);
        System.out.println(out);
    }

    public static int findKthPositiveBruteForceApproach(int[] arr, int k) {

        // here if elements of array is not less than K then missing element will be k only. otherwise,
        // if it is less than K then one place has been taken in the range of 1 to k, so we have to increase k
        // to one position because we will get answer to + 1 position
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= k) k++;
            else break;
        }

        return k;
    }

    public static int findKthPositive(int[] arr, int k) {

        int start = 1;
        int end = arr[arr.length - 1];

        if (k < arr[0]) return k;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // according





        }

        return 0;

    }
}
