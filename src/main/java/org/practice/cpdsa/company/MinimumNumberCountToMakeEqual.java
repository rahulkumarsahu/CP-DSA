package org.practice.cpdsa.company;

import java.util.Arrays;
import java.util.OptionalInt;

public class MinimumNumberCountToMakeEqual {

    public static void main(String[] args) {

        int length = 5;

        int[] a = {5, 7, 10, 5, 15};
        int[] b = {1, 2, 1, 5, 5};

        int count = getMinimumCount(a, b, length);

        System.out.println(count);

    }

    public static Integer getMinimumCount(int[] a, int[] b, int length) {

        OptionalInt element = Arrays.stream(a).min();
        int equalElement = 0;

        if(element.isPresent()) {
            equalElement = element.getAsInt();
        }

        int count = 0;

        for(int i = 0; i < length; i++) {

            if(a[i] != equalElement) {

                int difference = Math.abs(a[i] - equalElement);
                int steps = difference / b[i];
                if(a[i] - (steps * b[i]) == equalElement) {
                    count += steps;
                } else {
                    return -1;
                }
            }

        }

        return count;

    }
}
