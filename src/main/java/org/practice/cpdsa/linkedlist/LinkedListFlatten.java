package org.practice.cpdsa.linkedlist;

class NodeData {
    NodeData right;
    NodeData next;
    int data;
}

/*
 * Linked class contains the necessary functions to make the operations.
 */
class Linked {
    NodeData root;

    public Linked() {
        root = null;
    }

    /*
     * flatten() method is used to flat the complex Linked List
     */
    public NodeData flatten(NodeData node) {
        if (node == null || node.right == null)
            return node;
        return merge(node, flatten(node.right));
    }

    /*
     * merge() method is used to merge the two rows of a list in consecutive and
     * sorted manner that'll lead to the flattening of Linked List
     */
    public NodeData merge(NodeData first, NodeData second) {
        // flag new node
        NodeData temp = new NodeData();
        NodeData finalList = temp;
        // Based on node's value, nodes would be arranged
        while (first != null && second != null) {
            if (first.data < second.data) {
                temp.next = first;
                first = first.next;
            } else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }
        temp.next = (first != null) ? first : second;
        finalList.next.right = null;
        return finalList.next;
    }

    /*
     * printLinkedList() method is used to print the Linked List (nodes)
     */
    public void printLinkedList(NodeData node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printLinkedList(node.next);
    }

    /*
     * getNewNode() method to generate a new node
     */
    public NodeData getNewNode(int key) {
        NodeData a = new NodeData();
        a.next = null;
        a.right = null;
        a.data = key;
        return a;
    }

    /*
     * insert method is used to insert the element in Linked List
     */
    public NodeData insert(NodeData node, int key) {
        if (node == null)
            return getNewNode(key);
        node.next = insert(node.next, key);
        return node;
    }
}

/*
 * Flatten class to initiate the operation.
 */
public class LinkedListFlatten {

    public static void main(String[] args) {

        NodeData root;
        Linked a = new Linked();
        root = a.insert(null, 20);
        root = a.insert(root, 22);
        root = a.insert(root, 25);
        root = a.insert(root, 65);
        root = a.insert(root, 70);

        root.right = a.insert(root.right, 7);
        root.right = a.insert(root.right, 12);
        root.right = a.insert(root.right, 23);
        root.right = a.insert(root.right, 34);

        root.right.right = a.insert(root.right.right, 10);
        root.right.right = a.insert(root.right.right, 15);
        root.right.right = a.insert(root.right.right, 17);
        root.right.right = a.insert(root.right.right, 18);
        root.right.right = a.insert(root.right.right, 21);
        root.right.right = a.insert(root.right.right, 33);

        root.right.right.right = a.insert(root.right.right.right, 32);
        root.right.right.right = a.insert(root.right.right.right, 39);
        root.right.right.right = a.insert(root.right.right.right, 40);

        NodeData flattenList = a.flatten(root);
        a.printLinkedList(flattenList);
    }
}

