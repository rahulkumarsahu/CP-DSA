package org.practice.cpdsa.queue;

import java.lang.reflect.Array;

// FIFO or LILO
public class CircularQueue<T> {

    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static final int MAX_SIZE = 40;
    private final T[] elements;

    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    public CircularQueue(Class<T> clazz) {
        elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public void enqueue(T data) throws QueueOverFlowException {
         if(isFull()) {
             throw new QueueOverFlowException("Queue is Full");
         }
         //initially the tailIndex will be -1 so increment by 1 and store value again same process
         tailIndex = (tailIndex + 1) % elements.length;
         elements[tailIndex] = data;
         // when we are inserting a first data in queue at that case headIndex will be 0
         if(headIndex == SPECIAL_EMPTY_VALUE) {
             headIndex = tailIndex;
         }

    }

    public T dequeue() throws QueueUnderFlowException {
        if(isEmpty()) {
            throw new QueueUnderFlowException("Queue is Empty");
        }
        // dequeue always happens from headIndex FIFO
        T data = elements[headIndex];

        // if both are equal that means we have dequeue all the elements from queue
        if(headIndex == tailIndex) {
            headIndex = SPECIAL_EMPTY_VALUE;
        } else {
            // head index should be incremented by 1 after dequeue
            headIndex = (headIndex + 1) % elements.length;
        }
        return data;
    }

    // to check queue is empty or not we use SPECIAL_EMPTY_VALUE and when value will store it will become 0 and
    // keep on increasing
    public boolean isEmpty() {
        return headIndex == SPECIAL_EMPTY_VALUE;
    }
     // size of queue is 14 means 0 to 13
    // in a queue if tail index is at 13 and head index will be at 0 so (13 + 1) % 14 = 0
    // if head index is 6 as it is circular queue after dequeue and tail index is at 5 so (5 + 1) % 14 = 6 (6 == 6)
    // so queue is full
    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % elements.length;
        return nextIndex == headIndex;
    }
}
