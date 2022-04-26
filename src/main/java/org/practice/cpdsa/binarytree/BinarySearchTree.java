package org.practice.cpdsa.binarytree;

import java.util.Stack;

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

    /**
     * sum = 27 found in which path?
     */
    private static Boolean hasPathSum(Node<Integer> root, int sum) {

        // here we will subtract node data from sum if sum == 0 we found the path and break
        if(root == null) {
            return (sum == 0);
        } else {
            // here we will subtract the data and recursive call the method
            int subSum = sum - root.getData();
            return (hasPathSum(root.getLeftChild(), subSum) || hasPathSum(root.getRightChild(), subSum));
        }
    }

    static int count = 0;
    static int sum = 0;
    public static Integer kSmallestElement(Node<Integer> root, int k) {

        Stack<Node<Integer>> st = new Stack<>();
        // In BST the smallest element will be in left side so add all in stack of left side only
        while (root != null) {
            st.push(root);
            root = root.getLeftChild();
        }

        while (k != 0) {

            Node<Integer> n = st.pop();
            k--;
            if (k == 0) return n.getData();
            // again push the right element till end
            Node<Integer> right = n.getRightChild();
            while (right != null) {
                st.push(right);
                right = right.getLeftChild();
            }
        }

        return -1;
    }
}
