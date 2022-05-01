package org.practice.cpdsa.company.google;


public class MinimumRotation {

    public static void main(String[] args) {

         int[] top = new int[]{1,2,1,1,1,2,2,2};
         int[] bottom = new int[]{2,1,2,2,2,2,2,2};

        int output = minDominoRotations(top, bottom);
        System.out.println(output);
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {

        int maxTopCount = 0;
        int maxTopValue = 0;
        int maxBottomValue = 0;
        int maxBottomCount = 0;

        int[] topArray = new int[6];
        int[] bottomArray = new int[6];

        for(int i = 0; i < topArray.length; i++) {
            topArray[tops[i] - 1]++;
            bottomArray[bottoms[i] - 1]++;
        }
        // N
       // for(Integer top : tops)  topArray[top - 1]++;
         // N
       // for(Integer bottom : bottoms) bottomArray[bottom - 1]++;


        for(int i = 0; i < 6; i++) {
            if(maxTopCount < topArray[i]) {
                maxTopCount = topArray[i];
                maxTopValue = i + 1;
            }
            if(maxBottomCount < bottomArray[i]) {
                maxBottomValue = i + 1;
                maxBottomCount = bottomArray[i];
            }
        }
        int count = 0;
        if(maxTopCount >= maxBottomCount) {
          // N
            for(int i = 0; i < tops.length; i++) {
                if(tops[i] != maxTopValue) {
                      if(bottoms[i] == maxTopValue) {
                          count++;
                      } else {
                          return -1;
                      }
                }
            }
        } else {
            // N
            for(int i = 0; i < tops.length; i++) {
                if(bottoms[i] != maxBottomValue) {
                    if(tops[i] == maxBottomValue) {
                        count++;
                    } else {
                        return -1;
                    }
                }
            }

        }

        return count;
    }

}
