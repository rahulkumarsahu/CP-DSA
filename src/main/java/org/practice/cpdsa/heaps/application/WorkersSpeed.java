package org.practice.cpdsa.heaps.application;

import java.util.*;

// https://www.geeksforgeeks.org/maximize-product-of-sum-of-speeds-o-k-workers-and-their-minimum-efficiency/
public class WorkersSpeed {

    public static void main (String[] args) {

        Vector<Integer> speed = new Vector<>();
        speed.add(2);
        speed.add(10);
        speed.add(3);
        speed.add(1);
        speed.add(5);
        speed.add(8);

        Vector<Integer> efficiency = new Vector<>();
        efficiency.add(5);
        efficiency.add(4);
        efficiency.add(3);
        efficiency.add(9);
        efficiency.add(7);
        efficiency.add(2);

        int K = 2;

        // Function Call
        System.out.println(maximizePerformance(speed, K, efficiency));
    }

    private static Integer maximizePerformance(Vector<Integer> speed, int k, Vector<Integer> efficiency) {
        /**
        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>((p1, p2) -> {
           if(p1.getSpeed() != p2.getSpeed()) {
               return p2.getSpeed() - p1.getSpeed();
           }
           return p2.getEfficiency() - p1.getEfficiency();
        });
         **/
        List<Pair> pairList = new ArrayList<>();
        for(int i = 0; i < speed.size(); i++) {
            pairList.add(new Pair(speed.get(i), efficiency.get(i)));
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = 0; i < k; i++) {
            Pair pair = pairList.get(i);
            sum += pair.getSpeed();
            min = Math.min(min, pair.getEfficiency());
        }

        return sum * min;
    }

}

class Pair implements Comparable {
    public Integer speed;
    public Integer efficiency;

    public Pair(Integer speed, Integer efficiency) {
        this.speed = speed;
        this.efficiency = efficiency;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Integer efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public int compareTo(Object o) {
        Pair p1 = (Pair) o;
        return Comparator.comparingInt(Pair::getSpeed).reversed().thenComparingInt(Pair::getEfficiency).reversed().compare(this, p1);
    }
}