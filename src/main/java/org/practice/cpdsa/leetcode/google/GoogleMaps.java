package org.practice.cpdsa.leetcode.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GoogleMaps {

    private static int solve(int n, int t, int[][] task) {

        // to change the order of priority queue using reverse order...
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        // sorting array by task
        Arrays.sort(task, Comparator.comparingInt(data -> data[0]));

        int sum = 0;
        int max = 0;

        for(int i=0; i < n; i++){
            int time = t;
            int distance = 2 * task[i][0];
            int timeRemaining = time - distance;
            int currentEffort = task[i][1];

            if(timeRemaining < 0){
                break;
            }
            while(sum > timeRemaining){
                sum -= priorityQueue.poll();
            }
            if(priorityQueue.isEmpty() && timeRemaining > currentEffort) {
                priorityQueue.add(currentEffort);
                sum += currentEffort;
            }
            else if(sum + currentEffort <= timeRemaining) {
                priorityQueue.add(currentEffort);
                sum += currentEffort;
            }
            else{
                Integer currentMax= priorityQueue.peek();
                if(currentMax != null && currentMax > currentEffort) {
                    priorityQueue.poll();
                    priorityQueue.add(currentEffort);
                    sum = sum - currentMax + currentEffort;
                }
            }
            max = Math.max(max, priorityQueue.size());
        }
        return max;

    }
}
