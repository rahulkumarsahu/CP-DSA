package org.practice.cpdsa.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {

    public int totalFruit(int[] fruits) {

        int i = 0;
        int j = 0;

        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while(j < fruits.length) {

            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            if(map.size() < 2) {
                max = Math.max(max, j - i + 1);
            } else if(map.size() == 2) {
                max = Math.max(max, j - i + 1);
            } else {

                while(map.size() > 2) {
                    map.put(fruits[i], map.get(fruits[i]) - 1);
                    if(map.get(fruits[i]) == 0) {
                        map.remove(fruits[i]);
                    }
                    i++;
                }

            }
            j++;
        }

        return max;
    }

}
