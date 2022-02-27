package org.practice.cpdsa.stack;

//space complexity O(N)
// Implementing to undo in any application
// Implementing the back button in web browser
// Holding the memory for recursive calls in a programming language
// LIFO
public class Stack<T> {

    private static final int MAX_SIZE = 40;
    private Element<T> top;
    private int size = 0;

    //O(1) time complexity
    public void push(T data) throws StackOverFlowException {
        if(size == MAX_SIZE) {
            throw new StackOverFlowException("Stack is full");
        }

        top = new Element<>(data, top);
        size++;
    }

    //O(1) time complexity
    public T pop() throws StackUnderFlowException {
        if(size == 0) {
            throw new StackUnderFlowException("Stack is empty");
        }
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    //O(1) time complexity
    public T peek() throws StackUnderFlowException {
        if(size == 0) {
            throw new StackUnderFlowException("Stack is empty");
        }
        return top.getData();
    }

    //O(1) time complexity
    public boolean isEmpty() {
        return size == 0;
    }

    //O(1) time complexity
    public boolean isFull() {
        return size == MAX_SIZE;
    }

    //O(1) time complexity
    public int getSize() {
        return size;
    }

}
