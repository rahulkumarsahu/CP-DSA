package org.practice.cpdsa.array.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    public static void main(String[] args) {
        int[][] firstList = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] output = intervalIntersection(firstList, secondList);
        System.out.println(Arrays.deepToString(output));

    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> result = new ArrayList<>();
        int[] temp = new int[2];

        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {

            temp[0] = Math.max(firstList[i][0], secondList[j][0]);
            temp[1] = Math.min(firstList[i][1], secondList[j][1]);

            if(temp[0] <= temp[1]) {
                result.add(temp);
                temp = new int[2];
            }
            //
            if (firstList[i][1] > secondList[j][1])
                j++;
            else
                i++;
        }

        return result.toArray(new int[result.size()][2]);

    }
}
