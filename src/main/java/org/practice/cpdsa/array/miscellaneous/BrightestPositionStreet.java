package org.practice.cpdsa.array.miscellaneous;

import java.util.Map;
import java.util.TreeMap;

public class BrightestPositionStreet {

    public int brightestPosition(int[][] lights) {

        int left;
        int right;

        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        for(int[] light : lights) {
            // here
            left = (light[0] - light[1]); // taking start point
            right = (light[0] + light[1] + 1); // taking end point according to question
            treemap.put(left, (treemap.getOrDefault(left, 0) + 1)); // prefix sum concept start + 1
            treemap.put(right, (treemap.getOrDefault(right, 0) - 1)); // prefix sum concept (end + 1) - 1
        }

        int countBright = 0;
        int maxBrightness = 0;
        int maxBrightPoint = 0;

        for(Map.Entry<Integer, Integer> entry : treemap.entrySet()) {
            // counting the bright point it will get balanced by +1 and -1 prefix sum concept do dry run to understand
            countBright += entry.getValue();

            if(maxBrightness < countBright) {
                maxBrightness = countBright;
                maxBrightPoint = entry.getKey();
            }

        }
        return maxBrightPoint;
    }
}
