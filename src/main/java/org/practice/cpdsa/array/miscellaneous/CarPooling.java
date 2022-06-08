package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarPooling {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> result = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0, Collectors.toList()));

        System.out.println(result.get(true));
        System.out.println(result.get(false));
    }
}
