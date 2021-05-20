package org.practice.cpdsa.searching;

import org.practice.cpdsa.binarytree.Node;

// O(logN)
// worst O(N)
public class BinarySearchTree {


    public static Node<Integer> insert(Node<Integer> head, Node<Integer> node) {
        // Base case
        if(head == null) {
            return node;
        }
        // here if less than check in left side or check in right side
        if(node.getData() <= head.getData()) {
            head.setLeftChild(insert(head.getLeftChild(), node));
        } else {
            head.setRightChild(insert(head.getRightChild(), node));
        }
        return head;
    }

    public static Node<Integer> lookup(Node<Integer> head, Integer data) {
        // Base case
        if(head == null) {
            return null;
        }
        if(head.getData().equals(data)) {
            return head;
        }
        // here if less than check in left side or check in right side
        if(data <= head.getData()) {
           return lookup(head.getLeftChild(), data);
        } else {
            return lookup(head.getRightChild(), data);
        }
    }

    public static int minValue(Node<Integer> head) {
        if(head == null) {
            return Integer.MIN_VALUE;
        }

        if(head.getLeftChild() == null) {
            return head.getData();
        }

        return minValue(head.getLeftChild());
    }

}
