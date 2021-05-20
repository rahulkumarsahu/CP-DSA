package org.practice.cpdsa.binarytree;

public class InOrderTraversal {

    /**
     *             A
     *          /     \
     *         B       C
     *              /    \
     *             D      E
     *            /  \     \
     *           F    H     G
     *  DFS -> all the left most traverse first before the node itself then node
     *         will be process then right side will be traverse  B -> A -> F -> D -> H -> C -> E -> G
     */
    // only position of print is different from preOrder
    public static void inOrder(Node<Character> root) {
        if(root == null) {
            return;
        }
        // here as we know we have to go first depth of left most then right of same level
        inOrder(root.getLeftChild());
        System.out.println(root);
        inOrder(root.getRightChild());
    }
}
