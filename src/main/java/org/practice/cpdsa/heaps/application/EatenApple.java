package org.practice.cpdsa.heaps.application;

import java.util.Comparator;
import java.util.PriorityQueue;

public class EatenApple {

    public static void main(String[] args) {
        EatenApple et = new EatenApple();
        et.eatenApple();
    }

    public void eatenApple() {

        int[] apples = new int[]{3,0,1,5,9,7,3,1,0,1};
        int[] days = new int[]{9,0,3,1,5,9,6,3,0,7};

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getDiff));

        int count = 0;
        int i = 0;

        while (i < apples.length || pq.size() > 0) {

            if(i < apples.length && apples[i] > 0 && i + days[i] - 1 >= i) {
                pq.add(new Pair(i + days[i] - 1, apples[i]));
            }

            if(pq.size() == 0) {
                i++;
                continue;
            }

            Pair pair = pq.poll();

            if(pair.diff >= i) {
                count++;
                i++;
                pair.apples--;
                if(pair.apples != 0) {
                    pq.add(new Pair(pair.diff , pair.apples));
                }
            }
        }

        System.out.println(count);

    }

    class Pair {
        int diff;
        int apples;

        public Pair(int diff, int apples) {
            this.diff = diff;
            this.apples = apples;
        }

        public int getDiff() {
            return diff;
        }

        public void setDiff(int diff) {
            this.diff = diff;
        }

        public int getApples() {
            return apples;
        }

        public void setApples(int apples) {
            this.apples = apples;
        }
    }
}

