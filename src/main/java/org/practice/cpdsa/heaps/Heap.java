package org.practice.cpdsa.heaps;

import java.lang.reflect.Array;

// heap has two property minimum heap and maximum heap
// min heap will be having minimum value as root and below that every node parent should have lesser value then children
// vice versa for maximum heap
// binary tree is the good to implement heap we will implement using array.
// H & H-1 can have no child and if H - 1 have child then only we can Have child in H
/**
 *
 *    5, 8, 6, 9, 12, 11, 7, 15, 10 -> array
 *                    5
 *                 8      6
 *               9   12 11  7
 *             15 10
 */
public abstract class Heap<T extends Comparable<T>> {

    private static int maxSize = 40;
    private T[] array;
    private int count = 0;

    protected Heap(Class<T> clazz) {
        this(clazz, maxSize);
    }

    protected Heap(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
    }

    public abstract void shiftDown(int index);

    public abstract void shiftUp(int index);

    // pass parent index to get left child
    // in array min value will be 0 index then 2*i + 1 & 2*i + 2 will be used to calculate the left and right child index
    // after that for that child index in the array we will calculate the left and right in array
    public int getLeftChildIndex(int index) {
       int leftChild = 2 * index + 1;
       if(leftChild >= count) {
           return -1;
       }
       return  leftChild;
    }

    public int getRightChildIndex(int index) {
        int rightChild = 2 * index + 2;
        if(rightChild >= count) {
            return -1;
        }
        return  rightChild;
    }

    public int getParentIndex(int index) {
        if(index < 0 || index > count) {
            return -1;
        }
        return (index - 1) / 2;
    }

    public int getCount() {
        return count;
    }

    public Boolean isEmpty() {
        return count == 0;
    }

    public Boolean isFull() {
        return count == maxSize;
    }

    public T getElementAtIndex(int index) {
        return array[index];
    }

    public void swap(int index1, int index2) {
        T tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

    public void insert(T data) throws HeapFullException {
        // here first check the array length
        if(count >= array.length){
            throw new HeapFullException("Heap is Full");
        }
        // if space is there insert data into last position in array then shift up to make heap
        array[count] = data;
        shiftUp(count);
        count++;
    }

    public T removeHighestPriority() throws  HeapEmptyException {

        T min = getHighestPriority();

        if(count == 0) {
            throw new HeapEmptyException("Heap is Empty");
        }

        // copy last position to first position then shift down
        array[0] = array[count - 1];
        count--;
        shiftDown(0);

        return min;
    }

    private T getHighestPriority() throws HeapEmptyException {

        if(count == 0) {
            throw new HeapEmptyException("Heap is Empty");
        }

        return array[0];
    }

}
