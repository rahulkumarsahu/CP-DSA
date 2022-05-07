package org.practice.cpdsa.binary_search.application;

import java.util.Scanner;

public class FindTransitionPoint {

    public static int findTransition(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = (low + high) / 2;
            if(arr[mid] == 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[]args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
         scanner.close();
        System.out.println(findTransition(arr));
    }
}
