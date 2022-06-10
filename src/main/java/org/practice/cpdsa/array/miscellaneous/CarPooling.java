package org.practice.cpdsa.array.miscellaneous;

import java.util.*;
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

    public boolean carPooling3(int[][] trips, int capacity) {
        // sorting by start position because car moves only in one direction
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> endPositionPQ = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int passengers = 0;

        for (int[] trip : trips) {
            // taking current start position
            int currentStartPosition = trip[1];
            // here pq is not empty and current start position is greater than the end position of current trip
            // that means we have to drop some passengers
            // array is sorted
            // overlapping check
            while (!endPositionPQ.isEmpty() && currentStartPosition >= endPositionPQ.peek()[2]) {
                passengers -= endPositionPQ.poll()[0];
            }
            passengers += trip[0];
            endPositionPQ.add(trip);
            // 3 2 7-8 3 9-3 7 9-2 10 12
            // 327 - 839 -> 3 > 7 No -> 11
            //pq = 327-839
            // 379 -> 7 >= 7 > true 11 - 3 -> drop 327
            // pq839
            if (passengers > capacity) return false;

        }

        return true;
    }
}
