package org.practice.cpdsa.heaps.application;

public class MyComparator implements java.util.Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
