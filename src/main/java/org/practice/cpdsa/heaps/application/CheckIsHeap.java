package org.practice.cpdsa.heaps.application;

import java.util.LinkedList;
import java.util.Queue;

// Check if a given Binary Tree is Heap
public class CheckIsHeap {

    /**
     * perform level order traversal...
     * @param root root
     * @return boolean
     */
    private static boolean isHeap(Node root) {

        Queue<Node> queue = new LinkedList<>();
        // adding root node...
        queue.add(root);

        while (!queue.isEmpty()) {
            // get the First element from the queue
            Node temp = queue.peek();
            // remove the first element because it is processed...
            queue.remove();
            // if left is not null then check with previous element
            if(temp.left != null) {
                if(temp.data < temp.left.data) return false;
                queue.add(temp.left);
            }
            // if right is not null then check with previous element
            if(temp.right != null) {
                if(temp.data < temp.right.data) return false;
                queue.add(temp.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node root = null;
        root = newNode(10);
        root.left = newNode(9);
        root.right = newNode(8);
        root.left.left = newNode(7);
        root.left.right = newNode(6);
        root.right.left = newNode(5);
        root.right.right = newNode(4);
        root.left.left.left = newNode(3);
        root.left.left.right = newNode(2);
        root.left.right.left = newNode(1);

        // Function call
        if (isHeap(root))
            System.out.print("Given binary tree is a Heap\n");
        else
            System.out.print("Given binary tree is not a Heap\n");
    }

    // Tree node structure
    static class Node {
        int data;
        Node left;
        Node right;
    }

    // To add a new node
    static Node newNode(int k) {
        Node node = new Node();
        node.data = k;
        node.right = node.left = null;
        return node;
    }
}
