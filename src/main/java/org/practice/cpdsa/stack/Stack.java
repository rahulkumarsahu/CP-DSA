package org.practice.cpdsa.stack;

public class Stack<T> {

    private static final int MAX_SIZE = 40;
    private Element<T> top;
    private int size = 0;

    public void push(T data) throws StackOverFlowException {
        if(size == MAX_SIZE) {
            throw new StackOverFlowException("Stack is full");
        }

        top = new Element<>(data, top);
        size++;
    }

    public T pop() throws StackUnderFlowException {
        if(size == 0) {
            throw new StackUnderFlowException("Stack is empty");
        }
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public T peek() throws StackUnderFlowException {
        if(size == 0) {
            throw new StackUnderFlowException("Stack is empty");
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public int getSize() {
        return size;
    }

}
