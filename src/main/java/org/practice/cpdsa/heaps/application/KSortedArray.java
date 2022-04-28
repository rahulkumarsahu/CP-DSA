package org.practice.cpdsa.heaps.application;

import java.util.*;

//Sort a nearly sorted (or K sorted) array
public class KSortedArray {

    public static void main(String[] args) {
        int k = 4;
        int[] arr = { 10, 9, 8, 7, 4, 70, 60, 50 };
        kSort(arr, k);
    }
    // here we have to find this element who are not present in correct position and window size is given K.
    // if K = 3, and array is -> 6 5 3 2 8 10 9
    // 6 5 3 2 -> store in min heap -> why min heap ? because in the min heap root node will be the minimum -> 2
    // 8 6 5 3 -> 3
    // 10 8 6 5 -> 5
    // 10 9 8 6 -> 6
    private static void kSort(int[] arr, int k) {
           // In (length / K) iteration of the array get the minimum element and store in the list and
           // after that whatever is present in heap add to that list;


        PriorityQueue<Integer> queue = new PriorityQueue<>();

        List<Integer> dataList = new ArrayList<>();

        for (Integer data :  arr) {
            queue.add(data);
            if(queue.size() > k) {
                   dataList.add(queue.poll());
            }
        }
        Iterator<Integer> itr = queue.iterator();

        while (itr.hasNext()) {
            dataList.add(queue.peek());
            queue.poll();
        }

        dataList.forEach(System.out::println);
    }
}
