package org.practice.cpdsa.array.slidingwindow;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=uUXXEgK2Jh8&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=4
public class FirstNegativeNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{12, -1, -7, 8, -15, 30, 18, 28};
        int target = 3;
        firstNegativeNumber(arr, target, arr.length);

    }

    private static void firstNegativeNumber(int[] arr, int target, int length) {

        int i = 0;
        int j = 0;

        List<Integer> dataList = new ArrayList<>();

        while(j < length) {
            if(arr[j] < 0) {
                dataList.add(arr[j]);
            }

            if(j - i + 1 != target) {
                j++;
            } else if (j - i + 1 == target) {
                if(!dataList.isEmpty()) {
                    System.out.print(" " + dataList.get(0));
                    if (dataList.get(0) == arr[i]) {
                        dataList.remove(dataList.get(0));
                    }
                }
               i++;
               j++;
            }
        }
    }
}
