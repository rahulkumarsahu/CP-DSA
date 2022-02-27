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
     *  DFS -> left most first and then right seconder than node itself  B -> F -> H -> D -> G -> E -> C -> A
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

// Pre Order ->  Traversing and printing the root level and left most then right node ->  A -> B -> C -> D -> F -> H -> E -> G
// In Order -> Traversing and printing left most first then root of that nodes then right node -> B -> A -> F -> D -> H -> C -> E -> G
// Post Order -> Traversing and printing the left most then right node then root node -> B -> F -> H -> D -> G -> E -> C -> A
