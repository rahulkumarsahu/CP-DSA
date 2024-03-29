package org.practice.cpdsa.stack;

public class NStack1 {

    // Array to implement the stacks.
    int[] arr;

    // Array to keep track of the indices of the top elements of every stack.
    int[] top;

    // Array to store the next pointers/indices.
    int[] next;

    int freeStart;

    NStack1(int N, int S) {

        // Create the arrays.
        arr = new int[S];
        top = new int[N + 1];
        next = new int[S];

        // Initialize all stacks as empty.
        for (int i = 0; i < N + 1; i++) {
            top[i] = -1;
        }

        // Initialize all spaces as free as initially the complete array is empty.
        for (int i = 0; i < S - 1; i++) {
            next[i] = i + 1;
        }

        // Set the last pointer of the free list to -1 to indicate the end of free list.
        next[S - 1] = -1;

        // Initialize the starting index of the free list.
        freeStart = 0;
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack,
    // and false otherwise.
    boolean push(int x, int m) {
        if (freeStart == -1) {
            // Array is full. So, element cannot be inserted.
            return false;
        }

        // Store the index of the first free slot in a temporary variable.
        int index = freeStart;

        // Update the starting index of the free list.
        freeStart = next[index];

        // Store the new element in the free slot.
        arr[index] = x;

        // Update the next pointer of the new element.
        next[index] = top[m - 1];

        // Add the element to the stack by updating the head/top of the stack list.
        top[m - 1] = index;

        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise
    // returns the popped element.
    int pop(int m) {
        if (top[m - 1] == -1) {
            // Stack is empty. So, return -1.
            return -1;
        }

        // Find the index of the top element of the stack.
        int index = top[m - 1];

        // Remove the element from the stack by updating the head/top of the stack list.
        top[m - 1] = next[index];

        // Add the free slot to the free list.
        next[index] = freeStart;
        freeStart = index;

        // Return the popped element.
        return arr[index];
    }

}

