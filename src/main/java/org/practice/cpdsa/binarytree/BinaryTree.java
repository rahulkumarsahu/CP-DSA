package org.practice.cpdsa.binarytree;

public class BinaryTree {

    public static int maxDepth(Node<Integer> head) {

        if(head == null) {
            return 0;
        }

        // they are leaf node return 0 this problem has 2 base cases
        if(head.getLeftChild() == null && head.getRightChild() == null) {
            return 0;
        }
        // when it reaches to leaf node it will return 0 and 1 will be keep on adding
        int maxLeftDepth = 1 + maxDepth(head.getLeftChild());
        int maxRightDepth = 1 + maxDepth(head.getRightChild());

        return Math.max(maxLeftDepth, maxRightDepth);

    }

    /**
     *             A
     *          /     \
     *         B       C
     *              /    \
     *             D      E
     *            /  \     \
     *           F    H     G
     *  in mirror all right node become left and left become right node
     */
    public static void mirror(Node<Integer> head) {

        if(head == null) {
            return;
        }
        mirror(head.getLeftChild());
        mirror(head.getRightChild());

        // swap when it reaches to leaf node
        Node<Integer> tempNode = head.getLeftChild();
        head.setLeftChild(head.getRightChild());
        head.setRightChild(tempNode);
    }



    /**
     * Important Question need to understand clearly -> Code from Internet
     * for given number of nodes how many types of tree are possible
     * if numNodes = 3
     *      A                          A
     *     |                            \
     *    B   -> similarly mirror ->     B -> mirror ->      A
     *   /                              /                  /   \
     *  C                              C                  B     C
     * so total = 2 + 2 + 1 = 5
     */
    public static int countTrees(int numNodes) {

        if(numNodes <=1) {
            return 1;
        }

        int sum = 0;
        for(int i = 1; i <= numNodes; i++) {
            int countLeftSubTrees = countTrees(i - 1);
            int countRightSubTrees = countTrees(numNodes - i);
            sum = sum + (countLeftSubTrees * countRightSubTrees);
        }
        return sum;
    }

    public static void printRange(Node<Integer> root, int lb, int ub) {

        if(root == null) {
            return;
        }

        // when lb is less than left child it will go on depth
        if(lb <= root.getData()) {
            printRange(root.getLeftChild(), lb, ub);
        }

        if(root.getData() >= lb && root.getData() <= ub) {
            System.out.println(root.getData());
        }

        // when ub is greater than right child it will go on depth
        if(ub > root.getData()) {
            printRange(root.getRightChild(), lb, ub);
        }
    }

    // initial call integer min and max value
    public  static Boolean isBST(Node<Integer> root, int min, int max) {

        // it reaches leaf node means it is correct
        if(root == null) {
            return true;
        }

        // if min less than data and max greater than the node data means it is not BST
        if(root.getData() <= min || root.getData() > max) {
            return false;
        }

        // here first min will be Integer.min and max will be root.getData
        // so if we will get any currentHead.getData <= min || currentHead.getData() > previousNode.getData()
        // which we are passing as max.
        // here second min will be root.getData(), Integer.max
        // so if we will get any currentHead.getData <= previousNode.getData()....
        return isBST(root.getLeftChild(), min, root.getData()) && isBST(root.getRightChild(), root.getData(), max);

    }
}
