package org.practice.cpdsa.array.miscellaneous;

import java.util.*;

public class UnionTwoSortedArray {

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {

        Set<Integer> output = new HashSet<>();

        int i = 0;
        int j = 0;

        while(i < n && j < m) {

            if(arr1[i] == arr2[j]) {
                output.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                output.add(arr1[i]);
                i++;
            } else {
                output.add(arr2[j]);
                j++;
            }

        }

        while(i < n) {
            output.add(arr1[i]);
            i++;
        }

        while(j < m) {
            output.add(arr2[j]);
            j++;
        }

        ArrayList<Integer> data = new ArrayList<>(output);
        Collections.sort(data);

        return data;

    }
}
