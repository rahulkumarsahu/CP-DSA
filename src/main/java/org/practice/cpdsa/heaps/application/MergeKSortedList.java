package org.practice.cpdsa.heaps.application;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
    // 3 4 5 -> 0
    // 1 2 3 -> 1
    // 6 7 8 -> 2
    public static void main(String[] args) {

        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        list1.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(7);
        list3.add(8);

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

       List<Integer> out = mergeKSortedList.mergeKSortedList(lists);

       out.forEach(System.out::println);

    }
    // 0->0-> 1
    // 1->0->1
    // 2->0->6
    class Triplet implements Comparable<Triplet> {
        int li;
        int di;
        int data;

        Triplet(int li, int di, int data) {
            this.li = li;
            this.di = di;
            this.data = data;
        }

        @Override
        public int compareTo(Triplet o) {
            return this.data - o.data;
        }
    }

    private List<Integer> mergeKSortedList(List<List<Integer>> listArray) {

        PriorityQueue<Triplet> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < listArray.size(); i++) {
            priorityQueue.add(new Triplet(i, 0, listArray.get(i).get(0)));
        }
        List<Integer> output = new ArrayList<>();

        while(!priorityQueue.isEmpty()) {

            Triplet tp = priorityQueue.remove();
            output.add(tp.data);
            tp.di++;

            if(tp.di < listArray.get(tp.li).size()) {
                tp.data = listArray.get(tp.li).get(tp.di);
                priorityQueue.add(tp);
            }

        }

        return output;
    }
}
