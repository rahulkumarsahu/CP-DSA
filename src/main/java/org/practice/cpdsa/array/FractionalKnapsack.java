package org.practice.cpdsa.array;

import java.util.Arrays;

public class FractionalKnapsack {

    public static void main(String[] args) {
        Item[] items = new Item[]{new Item(60, 10), new Item(100, 20), new Item(120, 30)};
        int target = 50;
        int max = fractionalKnapsack(items, target);

        System.out.println(max);
    }
    // nlogn + N
    private static int fractionalKnapsack(Item[] items, int target) {
        int finalValue = 0;
        int finalWeight = 0;
        // considering it is sorted if not we will sort by the fraction (value / weight) in desc order
        Arrays.sort(items, (i1, i2) -> {
            double v1 = (double) (i1.getValue()) / (double) (i1.getWeight());
            double v2 = (double) (i2.getValue()) / (double) (i2.getWeight());

            return Double.compare(v1, v2);
        });

        for(Item item : items) {

            if(finalWeight + item.getWeight() <= target) {
                finalWeight = finalWeight + item.getWeight();
                finalValue = finalValue + item.getValue();
            } else {
                int remain = target - finalWeight;
                finalValue = finalValue + (item.getValue()/item.getWeight()) * remain;

            }

        }

        return finalValue;
    }

}
