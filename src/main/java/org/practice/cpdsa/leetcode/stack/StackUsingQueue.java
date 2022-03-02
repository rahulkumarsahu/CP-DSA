package org.practice.cpdsa.leetcode.stack;

import java.util.*;


public class StackUsingQueue {

    private static Queue<Integer> queue = new LinkedList<>();

    public static void push(int x) {
        queue.add(x);
        for (int i=1; i<queue.size(); i++)
            queue.add(queue.remove());
    }

    public static void pop() {
        queue.remove();
    }

    public static int top() {
        return queue.peek();
    }

    public static boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {

        StackUsingQueue.push(1);
        StackUsingQueue.push(2);
        StackUsingQueue.push(3);
        System.out.println(StackUsingQueue.top());

    }
}
