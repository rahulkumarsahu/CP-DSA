package org.practice.cpdsa.heaps.application;

import java.util.*;

public class KMaxSumCombinations {

    public static void main(String[] args) {
        List<Integer> output = kMaxSumCombination(Arrays.asList(1, 3, 5), Arrays.asList(6, 4, 2), 2);
        output.forEach(System.out::println);
    }

    public static List<Integer> kMaxSumCombination(List<Integer> a, List<Integer> b, int k){

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int temp = k;
        for(int i = 0; i < a.size(); i++) {
            pq1.add(a.get(i));
            pq2.add(b.get(i));
        }

        while(k-- > 0) {
            l1.add(pq1.poll());
            l2.add(pq2.poll());
        }
        PriorityQueue<Integer> combination = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < temp; i++) {
            for(int j = 0; j < temp; j++) {
                combination.add(l1.get(i) + l2.get(j));
            }
        }

        List<Integer> list = new ArrayList<>();

        while(temp-- > 0) {
            list.add(combination.poll());
        }

        return list;
    }

    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k) {
        // Array to store all the possible sum combinations.
        ArrayList<Integer>tempArray = new ArrayList<>();

        // Loop to traverse the array 'A".
        for (int i = 0; i < n; i++) {
            // Loop to traverse the array 'B'.
            for (int j = 0; j < n; j++) {
                int currentSum = a.get(i) + b.get(j);
                // Add the sum of current combination.
                tempArray.add(currentSum);
            }
        }
        // Sort the array in descending order.
        Collections.sort(tempArray, Collections.reverseOrder());

        // Return the first 'K' values.
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(tempArray.subList(0, k));

        return result;
    }
}
