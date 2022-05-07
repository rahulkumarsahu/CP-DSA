package org.practice.cpdsa.binary_search.application;

import java.util.Scanner;

public class MaximumNumberOf1Row {

    public static int findRow(int[][] arr) {

        int max = Integer.MIN_VALUE;
        int answer = -1;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int output = findTransition(arr[i]);
            int data = arr[i].length - output;
            count += data;
            if(data > max) {
                answer = i;
                max = data ;
            }
        }
        System.out.println("The maximum number of one in row is :- " + max);
        System.out.println("The total number of one in each row is :- " + count);
        return answer;
    }

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
        int m = scanner.nextInt();

        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        System.out.println(findRow(mat));
    }
}
