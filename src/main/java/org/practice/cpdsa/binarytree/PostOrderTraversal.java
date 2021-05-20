package org.practice.cpdsa.binarytree;

public class PostOrderTraversal {

    /**
     *             A
     *          /     \
     *         B       C
     *              /    \
     *             D      E
     *            /  \     \
     *           F    H     G
     *  DFS -> left most first and then right most second than node itself  B -> F -> H -> D -> G -> E -> C -> A
     */
    public static void postOrder(Node<Character> root) {
        if(root == null) {
            return;
        }
        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        System.out.println(root);
    }
}
