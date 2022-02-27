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
    // here we are using queue as part of BFS which is first inserted will be first to remove
    public static void breadthFirst(Node<Character> root) throws QueueOverFlowException, QueueUnderFlowException {

        // 1. check root is not null
        // 2. add root node to queue
        // 3. remove first element from queue and we got A
        // 4. enqueue left node of root we got b added in queue
        // 5. enqueue right node of root we got c added in queue
        // 6. queue is not empty so go to dequeue b both null next iteration
        // and so on.....

        // if root == null then nothing to traverse
        if(root == null) {
            return;
        }
        Queue<Node<Character>> queue = new Queue<>();
        // root node is not empty so putting into queue
        queue.enqueue(root);
        // loop while queue is not empty
        while(!queue.isEmpty()) {
            // remove the first element and because BFS lest most and same level ,so basically first inserted printed
            Node<Character> node = queue.dequeue();
            System.out.println(node.getData());
            // then as left most print first, so we are adding the node data into queue first F C F S
            if(node.getLeftChild() != null) {
                queue.enqueue(node.getLeftChild());
            }
            //
            if(node.getRightChild() != null) {
                queue.enqueue(node.getRightChild());
            }

            // order is most important because left most traverse first then right one
        }
    }

}
