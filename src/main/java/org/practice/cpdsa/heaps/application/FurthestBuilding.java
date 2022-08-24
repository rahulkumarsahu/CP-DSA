package org.practice.cpdsa.heaps.application;

import java.util.PriorityQueue;

public class FurthestBuilding {

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < heights.length - 1; i++) {

            int diff = heights[i + 1] - heights[i];

            if(diff < 0) {
                continue;
            }

            pq.offer(diff);

            if(ladders < pq.size()) {
                bricks -= pq.poll();

            }

            if(bricks < 0) return i;
        }

        return heights.length - 1;

    }
    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
    }
}
