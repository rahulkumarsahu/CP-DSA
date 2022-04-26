package org.practice.cpdsa.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    static class Node<T, U> {
        Node<T, U> previous;
        Node<T, U> next;
        T key;
        U value;

        public Node(Node<T, U> previous, Node<T, U> next, T key, U value) {
            this.previous = previous;
            this.next = next;
            this.key = key;
            this.value = value;
        }

        public Node<T, U> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T, U> previous) {
            this.previous = previous;
        }

        public Node<T, U> getNext() {
            return next;
        }

        public void setNext(Node<T, U> next) {
            this.next = next;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public U getValue() {
            return value;
        }

        public void setValue(U value) {
            this.value = value;
        }
    }

    private Map<K, Node<K, V>> cache;
    private Node<K, V> head;
    private Node<K, V> tail;
    private int maxSize;
    private int currentSize;

    public LRUCache(int maxSize) {
        this.cache = new HashMap<>();
        this.head = new Node<>(null, null, null, null);
        this.tail = new Node<>(null, null, null, null);
        this.maxSize = maxSize;
        this.currentSize = 0;
    }

    public Map<K, Node<K, V>> getCache() {
        return cache;
    }

    public void setCache(Map<K, Node<K, V>> cache) {
        this.cache = cache;
    }

    public Node<K, V> getHead() {
        return head;
    }

    public void setHead(Node<K, V> head) {
        this.head = head;
    }

    public Node<K, V> getTail() {
        return tail;
    }

    public void setTail(Node<K, V> tail) {
        this.tail = tail;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    // for get, we will get the value from map and whenever we are getting any value
    // that will get moved from actual position to near to head node
    // so for that will delete that node from that position and add it to near head and update the map also
    public V get(K key) {

        Node<K, V> tempNode = cache.get(key);

        if (tempNode == null) return null;

        // If key == most recently used(head.key) that means no swap is required
        else if (tempNode.key == head.key) return head.value;

        // Get the next and previous nodes
        Node<K, V> nextNode = tempNode.next;
        Node<K, V> previousNode = tempNode.previous;

        // If key == least recently used (tail.key) that means no swap is required
        if (tempNode.key == tail.key) {
            nextNode.previous = null;
            tail = nextNode;
        }
        // If we are in the middle, we need to update the items before and after our item
        else {
            previousNode.next = nextNode;
            nextNode.previous = previousNode;
        }

        // Finally, move our item to the MRU
        tempNode.previous = head;
        head.next = tempNode;
        head = tempNode;
        head.next = null;

        return tempNode.value;

    }

    // this method will put the value in close to head and if maxsize increases and then delete node close to tail
    // and update the map also
    public void put(K key, V value) {

        // if cache contains key already then
        if(cache.containsKey(key)) return;

        // put the new node at right most end of the linked list close to head;
        // creation of new node...
        Node<K, V> tempNode = new Node<>(head, null, key, value);
        head.next = tempNode;
        cache.put(key, tempNode);
        head = tempNode;

        // if currentSize is equal to maxSize
        if(currentSize == maxSize) {
            cache.remove(tail.key);
            tail = tail.next;
            tail.previous = null;
        }  else if (currentSize < maxSize) {
            if (currentSize == 0) {
                tail = tempNode;
            }
            currentSize++;
        }

        // Update cache size, for the first added entry update the LRU pointer
    }

    public int getSize() {

        return currentSize;
    }

    public Boolean isEmpty() {

        return currentSize == 0;
    }
}
