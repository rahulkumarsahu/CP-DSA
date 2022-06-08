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

    // https://www.codingninjas.com/codestudio/library/car-pooling
    //

    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1000];
        for(int i=0; i < trips.length; i++){
            for(int j = trips[i][1]; j < trips[i][2]; j++){
                arr[j] += trips[i][0];
                if(arr[j] > capacity) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean carPooling2(int[][] trips, int capacity) {
        int[] person = new int[10001];

        for(int[] t : trips) {
            person[t[1]] += t[0];
            person[t[2]] -= t[0];
        }

        for(int num : person) {
            capacity -= num;
            if(capacity < 0){
                return false;
            }
        }
        return true;
    }

}
