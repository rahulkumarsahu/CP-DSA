package org.practice.cpdsa.binarytree;

public class PreOrderTraversal {

    /**
     *             A
     *          /     \
     *         B       C
     *              /    \
     *             D      E
     *            /  \     \
     *           F    H     G
     *  DFS -> left most first and depth of that then same level right most  A -> B -> C -> D -> F -> H -> E -> G
     */
    public static void preOrder(Node<Character> root) {

        if(root == null) {
            return;
        }
        // here as we know we have to go first depth of left most then right of same level
        System.out.println(root);
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());

    }
}
