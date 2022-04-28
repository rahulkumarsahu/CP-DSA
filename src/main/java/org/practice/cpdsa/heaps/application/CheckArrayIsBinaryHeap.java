package org.practice.cpdsa.heaps.application;

public class CheckArrayIsBinaryHeap {

    public static void main(String[] args) {

        int[] arr = { 90, 15, 10, 7, 12, 2, 7, 3 };

        if (isHeap(arr, arr.length - 1))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    // in heap how we store if we want to store the left child it will be 2 * index + 1 and right child will be 2 * index + 2
    // and parent will be indexed - 1 / 2;
    private static boolean isHeap(int[] arr, int length) {
        // why length - 2 / 2 because this will give us count of the root in array 6 - 2 / 2 = 2 so 0,1,2
        for(int i = 0; i <= (length - 2) / 2; i++) {

            if(arr[i] <= arr[ 2 * i + 1]) {
                return false;
            }
            if(arr[i] <= arr[ 2* i + 2]) {
                return false;
            }

        }

        return true;
    }
}
