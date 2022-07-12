package org.practice.cpdsa.array.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] arr = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12} };
        spiralMatrixPrint(arr);
    }

    private static List<Integer> spiralMatrixPrint(int[][] arr) {
        List<Integer> list = new ArrayList<>();
        int m = arr.length;
        int n = arr[0].length;

        int count = 0;

        while(n * m > list.size()) {

            int i = count;
            int j = count;

            while(j < n - count && n * m > list.size()) {
                list.add(arr[i][j]);
                j++;
            }
            i++;
            j--;
            while(i < m - count && n * m > list.size()) {
                list.add(arr[i][j]);
                i++;
            }
            i--;
            j--;
            while(j >= count && n * m > list.size()) {
                list.add(arr[i][j]);
                j--;
            }
            j++;
            i--;
            while(i > count && n * m > list.size()) {
                list.add(arr[i][j]);
                i--;
            }

            count++;
        }

        return list;
    }
}
