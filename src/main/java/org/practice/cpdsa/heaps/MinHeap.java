package org.practice.cpdsa.heaps;

// Heap ify is the process to place the data into wrong position then by doing shift up or shift down
// based on head property (minimum or maximum) and structure H & H - 1 rule.
public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    public MinHeap(Class<T> clazz) {
        super(clazz);
    }

    public MinHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    // pass the element index which we have to move into correct position
    @Override
    public void shiftDown(int index) {
        // to get the left index and right index for the index which is in wrong position
        // it will return -1 when in array no element is there
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);

        // find the min left or right child index where we have to swap element in wrong position

        int smallIndex = -1;
        // if both have value means left child and right child is present then compare
        if (leftIndex != -1 && rightIndex != -1) {
            smallIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) > 0 ? leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            // if only left child is present
            smallIndex = leftIndex;
        } else if (rightIndex != -1) {
            // if only right child is present
            smallIndex = rightIndex;
        }

        // if left child and right child does not exist stop shifting down
        if (smallIndex == -1) {
            return;
        }

        // compare the smaller index with current index which is in wrong position and swap.
        if (getElementAtIndex(leftIndex).compareTo(getElementAtIndex(index)) < 0) {
            swap(smallIndex, index);
            shiftDown(smallIndex);
        }

    }

    @Override
    public void shiftUp(int index) {

        int parentIndex = getParentIndex(index);

        if(parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
            swap(parentIndex, index);
            shiftUp(parentIndex);
        }
    }
}
