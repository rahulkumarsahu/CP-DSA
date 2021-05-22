package org.practice.cpdsa.heaps;

public class KthMaximum {

    public static int getMaximum(MinHeap<Integer> minHeap) {
        int lastIndex = minHeap.getCount() - 1;
        int lastParentIndex = minHeap.getParentIndex(lastIndex);

        int firstChildIndex = lastParentIndex + 1;
         // here in min heap the largest maximum will be in leaf node so get the first child of leaf node
        // which will be last parent index + 1 and after that from first child index to go to last child Index.
        int maxElement = minHeap.getElementAtIndex(firstChildIndex);
        for(int i = firstChildIndex; i < lastIndex; i++) {
            if(maxElement < minHeap.getElementAtIndex(i)) {
                maxElement = minHeap.getElementAtIndex(i);
            }
        }
        return maxElement;
    }

    public static int getKthMaximum(MinHeap<Integer> minHeap) {
       
        return 0;
    }
}
