package org.practice.cpdsa.array.miscellaneous;

public class AllIntegerRangesAreCovered {

    public boolean isCovered(int[][] ranges, int left, int right) {

        for(int i = left; i <= right; i++) {

            if(!checkIsPossible(ranges, i)) {

                return false;
            }
        }

        return true;
    }

    public boolean checkIsPossible(int[][] ranges, int i) {

        for(int[] arr : ranges) {

            if(i >= arr[0] && i <= arr[1]) {

                return true;
            }

        }

        return false;
    }
    public boolean isCovered2(int[][] ranges, int left, int right) {

        int[] temp = new int[52];

        for(int i = 0; i < ranges.length; i++){
            int start = ranges[i][0];
            int end = ranges[i][1];
            temp[start] += 1;
            temp[end + 1] += -1;
        }
        for(int i = 1; i < temp.length; i++) {
            temp[i] += temp[i - 1];
        }

        for(int i = left; i <= right; i++) {
            if(temp[i] == 0)
                return false;
        }

        return true;
    }

}
