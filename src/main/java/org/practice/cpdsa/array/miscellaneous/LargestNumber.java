package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        for(int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] + "";
        }
        // a first so return -ve and b first so +ve
        // where a will be 2nd element and b will be 1st element

        Arrays.sort(arr, (a, b) -> {

            long a1 = Long.parseLong(a + b);
            long b1 = Long.parseLong(b + a);

            return Long.compare(a1, b1);
        });

        System.out.println(Arrays.toString(arr));

        if(arr[arr.length - 1].equals("0")) return "0";

        StringBuilder sb = new StringBuilder("");
        for(int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        return sb.toString();

    }
}
