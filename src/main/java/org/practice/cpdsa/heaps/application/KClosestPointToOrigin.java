package org.practice.cpdsa.heaps.application;

import java.util.*;

public class KClosestPointToOrigin {
    public int[][] kClosest(int[][] points, int k) {

        int[][] output = new int[k][2];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < points.length; i++) {
            map.put(i, points[i][0] * points[i][0] + points[i][1] * points[i][1]);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }

        for (int i = 0; i < k; i++) {
            output[i] = points[Objects.requireNonNull(queue.poll()).getKey()];
        }

        return output;

    }
}
