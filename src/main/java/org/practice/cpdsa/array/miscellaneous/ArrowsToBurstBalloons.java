package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;
import java.util.Comparator;

public class ArrowsToBurstBalloons {

    public static void main(String[] args) {
       int[][] points = new int[][]{{10, 16}, {2,8},{1,6},{7,12}};
       System.out.println(findMinArrowShots(points));
    }

    /**
     Given Array :- [[10,16],[2,8],[1,6],[7,12]]
     Sorted Array :- 0 [[1,6] [2,8] [7,12] [10, 16]]
     [1,6]
     **/

    public static int findMinArrowShots(int[][] points) {

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int[] temp = new int[2];
        temp[0] = points[0][0];
        temp[1] = points[0][1];

        int minimumNumberOfArrows = 1;

        for(int i = 1; i < points.length; i++) {

            int[] currentPoint = points[i];

            if(temp[1] >= currentPoint[0] && temp[0] <= currentPoint[0]) {

                temp[0] = Math.max(currentPoint[0], temp[0]);
                temp[1] = Math.min(currentPoint[1], temp[1]);

            } else {

                temp[0] = currentPoint[0];
                temp[1] = currentPoint[1];
                minimumNumberOfArrows++;
            }

        }

        //return minimumNumberOfArrows == 0 ? 1 : minimumNumberOfArrows;
        return minimumNumberOfArrows;
    }
}

/**
 -------------------------------------
 points = [[10,16],[2,8],[1,6],[7,12]]
 output = 2

 points = [[1,2],[3,4],[5,6],[7,8]]
 output = 4

 points = [[1,2],[2,3],[3,4],[4,5]]
 output = 2


 [[1,2],[2,3],[3,4],[4,5]] ->

 Sorting ? comaprission ?

 1. 1 and 2 ko compare kiya -> point minimum 2
 2.

 i
 1 2 3 4
 2 3 4 5
 j
 ----------------------------------

 Observation:-
 1. given Xstart and Xend of ballon
 2. arraow should be in xstart <= x <= xend to burst ballons
 3. minimum number of Arrows required

 [
 X
 X
 Y                                       <---------

 Y

 ]

 [[1,2],[2,3],[3,4],[4,5]]

 -> [2,2] [4,4]

 1
 [[10,16],[2,8],[1,6],[7,12]]

 array -> [10, 12][2, 6] -> 2

 -------------------------------------
 Given Array :- [[10,16],[2,8],[1,6],[7,12]]
 I
 Sorted Array :- [1,6] [2,8] [7,12] [10, 16]
 0 -> 2 ->
 [10 , 12] O(1)

 1
 2
 6
 8



 **/
