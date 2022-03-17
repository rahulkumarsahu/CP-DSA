package org.practice.cpdsa.binarytree;

import java.util.*;

public class BinaryTreeApplication {

    // the max distance different should be 1 of end node
    public static Boolean isBalancedTree(Node<Integer> root) {

        //isBalancedTreeFast same as getDiameterOfBinaryTreeFast...

        if (root == null) {
            return true;
        }

        Boolean left = isBalancedTree(root.getLeftChild());
        Boolean right = isBalancedTree(root.getRightChild());

        Boolean difference = Math.abs(getHeightOfBinaryTree(root.getLeftChild()) - getHeightOfBinaryTree(root.getRightChild())) <= 1;

        return difference && left && right;
    }

    // diameter is max distance between two end nodes...
    public static int getDiameterOfBinaryTree(Node<Integer> root) {

        if (root == null) {
            return 0;
        }

        int left = getDiameterOfBinaryTree(root.getLeftChild());
        int right = getDiameterOfBinaryTree(root.getRightChild());
        int leftAndRight = getHeightOfBinaryTree(root.getLeftChild()) + getHeightOfBinaryTree(root.getRightChild()) + 1;

        return Math.max(left, Math.max(right, leftAndRight));
    }

    public static int[] getDiameterOfBinaryTreeFast(Node<Integer> root) {

        if (root == null) {
            // 1st diameter 2nd height
            return new int[]{0, 0};
        }

        int[] leftPair = getDiameterOfBinaryTreeFast(root.getLeftChild());
        int[] rightPair = getDiameterOfBinaryTreeFast(root.getRightChild());

        int left = leftPair[0];
        int right = rightPair[0];

        int leftAndRight = leftPair[1] + rightPair[1] + 1;

        int[] answer = new int[2];
        answer[0] = Math.max(left, Math.max(right, leftAndRight));
        answer[1] = Math.max(leftPair[1], rightPair[1]) + 1;

        return answer;
    }

    public static int getHeightOfBinaryTree(Node<Integer> root) {

        if (root == null) {
            return 0;
        }

        int left = getHeightOfBinaryTree(root.getLeftChild());
        int right = getHeightOfBinaryTree(root.getRightChild());

        return Math.max(left, right) + 1;
    }

    public static Boolean isIdentical(Node<Integer> root1, Node<Integer> root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 == null) {
            return false;
        }

        if (root1 == null && root2 != null) {
            return false;
        }

        Boolean left = isIdentical(root1.getLeftChild(), root2.getLeftChild());
        Boolean right = isIdentical(root1.getRightChild(), root2.getRightChild());

        Boolean status = Objects.equals(root1.getData(), root2.getData());

        return left && right && status;
    }

    //   1
    // 2    3
    //    4    5
    // 1 3 2 4 5
    public static List<Integer> zigZagTraversal(Node<Integer> root) {

        List<Integer> output = new ArrayList<>();

        if (root == null) {
            return output;
        }

        Queue<Node<Integer>> queue = new LinkedList<>();

        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            // process level...
            int size = queue.size();
            // this required to store the data, so we can store in output in reverse order or normal order
            int[] answer = new int[size];

            for (int i = 0; i < size; i++) {
                Node<Integer> frontNode = queue.peek();
                queue.poll();
                // to traverse left to right or right to left...
                int index = Boolean.TRUE.equals(leftToRight) ? i : size - i - 1;
                assert frontNode != null;
                answer[index] = frontNode.getData();

                if (frontNode.getLeftChild() != null) {
                    queue.add(frontNode.getLeftChild());
                }

                if (frontNode.getRightChild() != null) {
                    queue.add(frontNode.getRightChild());
                }
                // to change the order from left to right or right to left...
                leftToRight = !leftToRight;

            }

            for (Integer data : answer) {
                output.add(data);
            }
        }

        return output;

    }

    // print left node without leaf node
    // print all leaf node
    // print right node without leaf node
    void traverseLeft(Node<Integer> root, List<Integer> answer) {
        //base case
        if ((root == null) || (root.getLeftChild() == null && root.getRightChild() == null))
            return;

        answer.add(root.getData());

        if (root.getLeftChild() != null)
            traverseLeft(root.getLeftChild(), answer);
        else
            traverseLeft(root.getRightChild(), answer);

    }

    void traverseLeaf(Node<Integer> root, List<Integer> answer) {
        //base case
        if (root == null)
            return;

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            answer.add(root.getData());
            return;
        }

        traverseLeaf(root.getLeftChild(), answer);
        traverseLeaf(root.getRightChild(), answer);

    }

    void traverseRight(Node<Integer> root, List<Integer> answer) {
        //base case
        if ((root == null) || (root.getLeftChild() == null && root.getRightChild() == null))
            return;

        if (root.getRightChild() != null)
            traverseRight(root.getRightChild(), answer);
        else
            traverseRight(root.getLeftChild(), answer);

        answer.add(root.getData());

    }

    List<Integer> boundary(Node<Integer> root) {
        List<Integer> answer = new ArrayList<>();

        if (root == null)
            return answer;

        answer.add(root.getData());

        //left part print/store
        traverseLeft(root.getLeftChild(), answer);

        //traverse Leaf Nodes

        //left subtree
        traverseLeaf(root.getLeftChild(), answer);
        //right subtree
        traverseLeaf(root.getRightChild(), answer);

        //traverse right part
        traverseRight(root.getRightChild(), answer);

        return answer;


    }

// top, left , right , bottom view....
    public static void leftView(Node<Integer> root) {
        List<Integer> dataList = new ArrayList<>();
        // index 0 because for left view we use level order traversal if we got data for any index we will ignore other...
        printLeftView(root, dataList, 0);
        printRightView(root, dataList, 0);

    }

    private static void printLeftView(Node<Integer> root, List<Integer> dataList, int index) {

        if(root == null) return;

        if(dataList.get(index) == null) {

            dataList.add(root.getData());
        }

        printLeftView(root.getLeftChild(), dataList, index + 1);
        printLeftView(root.getRightChild(), dataList, index + 1);
    }

    private static void printRightView(Node<Integer> root, List<Integer> dataList, int index) {

        if(root == null) return;

        if(dataList.get(index) == null) {

            dataList.add(root.getData());
        }


        printRightView(root.getRightChild(), dataList, index + 1);
        printRightView(root.getLeftChild(), dataList, index + 1);
    }

    private static void levelOrderTraversal(Node<Integer> root) {
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<Integer> frontNode = queue.poll();
            System.out.println(frontNode.getData());

            if(frontNode.getLeftChild() != null) {
                queue.add(frontNode.getLeftChild());
            }

            if(frontNode.getRightChild() != null) {
                queue.add(frontNode.getRightChild());
            }
        }
    }

    // for top view horizontal distancing will come into picture
    // hd means distance root will be 0 left side will increase like -1, -2
    // right side will increase 1, 2 ,and we have to print only value in particular index
    public static void topViewTraversal(Node<Integer> root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> dataMap = new HashMap<>();

        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair frontNode = queue.poll();
            if (!dataMap.containsKey(frontNode.hd)) {
                dataMap.put(frontNode.hd, frontNode.node.getData());
            }

            if(frontNode.node.getLeftChild() != null) {
                queue.add(new Pair(frontNode.hd - 1, frontNode.node.getLeftChild()));
            }

            if(frontNode.node.getRightChild() != null) {
                queue.add(new Pair(frontNode.hd + 1, frontNode.node.getRightChild()));
            }
        }

        // iterate the map to get the answer
    }

    public static void bottomViewTraversal(Node<Integer> root) {

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> dataMap = new HashMap<>();

        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair frontNode = queue.poll();
            dataMap.put(frontNode.hd, frontNode.node.getData());


            if(frontNode.node.getLeftChild() != null) {
                queue.add(new Pair(frontNode.hd - 1, frontNode.node.getLeftChild()));
            }

            if(frontNode.node.getRightChild() != null) {
                queue.add(new Pair(frontNode.hd + 1, frontNode.node.getRightChild()));
            }
        }

        // iterate the map to get the answer
    }

    static class Pair {

        int hd;
        Node<Integer> node;

        public Pair(int hd, Node<Integer> node) {
            this.hd = hd;
            this.node = node;
        }
    }

    //maximum sum of the longest path
    public static int maximumSumOfLongestPath(Node<Integer> root, int sum, int maxSum, int length, int maxLength) {

        if(root == null) {
            // greater than no need to check because if it is maximum length then will consider that sum as max sum
            if(length < maxLength) {
                maxSum = sum;
                maxLength = length;
            } else if(length == maxLength) {
                maxSum = Math.max(sum, maxSum);
            }

        }

        sum = sum + root.getData();

        maximumSumOfLongestPath(root.getLeftChild(), sum, maxSum, length + 1, maxLength);
        maximumSumOfLongestPath(root.getRightChild(), sum, maxSum, length + 1, maxLength);

        return maxSum;
    }

    public static Node<Integer> lowestCommonAncestor(Node<Integer> root, Integer n1, Integer n2) {

        if (root == null) {
            return null;
        }
        // the first one itself is the answer
        if(Objects.equals(root.getData(), n1) && Objects.equals(root.getData(), n2)) {
            return root;
        }

        lowestCommonAncestor(root.getLeftChild(), n1, n2);
        lowestCommonAncestor(root.getRightChild(), n1, n2);

        if(root.getLeftChild() != null && root.getRightChild() != null) {
            return root;
        } else if(root.getLeftChild() != null && root.getRightChild() == null) {
            return root.getLeftChild();
        } else if(root.getRightChild() != null && root.getLeftChild() == null) {
            return root.getRightChild();
        } else {
            return null;
        }
    }

    // K sum paths :- given value k and find how many path sum == k

    public static int kSumPath(Node<Integer> root, int count, List<Integer> list) {

        return count;
    }

    // kth ancestor
    // vertical traversal
    // sum of non-adjacent nodes..

}
