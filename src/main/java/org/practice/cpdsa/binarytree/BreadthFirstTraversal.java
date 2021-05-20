package org.practice.cpdsa.binarytree;

import org.practice.cpdsa.queue.Queue;
import org.practice.cpdsa.queue.QueueOverFlowException;
import org.practice.cpdsa.queue.QueueUnderFlowException;

public class BreadthFirstTraversal {

    /**
     *             A
     *          /     \
     *         B       C
     *              /    \
     *             D      E
     *            /  \     \
     *           F    H     G
     *  BFS -> left most first and same level  A -> B -> C -> D -> E -> F -> H -> G
     */
    public static void breadthFirst(Node<Character> root) throws QueueOverFlowException, QueueUnderFlowException {

        // 1. check root is not null
        // 2. add root node to queue
        // 3. remove first element from queue and we got A
        // 4. enqueue left node of root we got b added in queue
        // 5. enqueue right node of root we got c added in queue
        // 6. queue is not empty so go to dequeue b both null next iteration
        // and so on.....
        if(root == null) {
            return;
        }
        Queue<Node<Character>> queue = new Queue<>();
        // root node is not empty so putting into queue
        queue.enqueue(root);
        while(!queue.isEmpty()) {
            Node<Character> node = queue.dequeue();
            System.out.println(node.getData());

            if(node.getLeftChild() != null) {
                queue.enqueue(node.getLeftChild());
            }
            if(node.getLeftChild() != null) {
                queue.enqueue(node.getRightChild());
            }
        }
    }
}
