package org.practice.cpdsa.heaps.application;
import java.util.*;

public class SortMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {
        /**
         for(int k = 0; k < mat.length - 1; k++) {
         for(int i = 0; i < mat.length - 1; i++) {
         for(int j = 0; j < mat[0].length - 1; j++) {
         if(mat[i][j] > mat[i + 1][j+ 1]) {
         int temp = mat[i][j];
         mat[i][j] = mat[i + 1][j + 1];
         mat[i + 1][j + 1] = temp;
         }
         }
         }

         }

         return mat;
         **/
        // diff
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i = 0; i < mat.length; i++) {

            for(int j = 0; j < mat[0].length; j++) {

                int diff = i - j;

                if(!map.containsKey(diff)) {
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    map.put(diff, pq);
                }

                map.get(diff).add(mat[i][j]);

            }

        }

        for(int i = 0; i < mat.length; i++) {

            for(int j = 0; j < mat[0].length; j++) {

                PriorityQueue<Integer> pq = map.get(i - j);
                mat[i][j] = pq.remove();

            }

        }


        return mat;

    }
}
