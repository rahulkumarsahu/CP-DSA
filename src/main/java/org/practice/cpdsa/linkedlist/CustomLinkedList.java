package org.practice.cpdsa.linkedlist;

public class CustomLinkedList<T extends Comparable<T>> {

    // to keep the track of beginning node so adding an element at beginning will be O(1)
    private Node<T> head = null;
    // increment when data is getting added and decrement when data is getting deleted to get size in O(1)
    private Long size;
    // to keep the track of last node so adding an element at last will be O(1)
    private Node<T> tail = null;


    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    //to get the count in O(n)
    public int countNodes() {
        if(head == null) {
            return 0;
        } else {
            Node<T> curr = head;
            int count = 0;
            while(curr != null) {
                curr = curr.getNext();
                count++;
            }
            return count;
        }
    }

    //to add a node at the end in O(n)
    public void addNode(T data) {
        if(head == null) {
            head = new Node<>(data);
        } else {
            Node<T> curr = head;
            while(curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(new Node<>(data));
        }
    }

    public T popElement() {
        if(head != null) {
            T topElement = head.getData();
            head = head.getNext();
            return  topElement;
        }
        return null;
    }
}
// add new element at end -> O(n) for optimization keep track of last element
// add new element at beginning -> O(1) head we know
// finding an element -> O(N)
// delete first element and nth element ->O(1) and O(n)