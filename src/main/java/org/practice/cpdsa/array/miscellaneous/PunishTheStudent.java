package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;

public class PunishTheStudent {

    public static int shouldPunish (int[] roll, int[] marks, int n, double avg)  {

        int count = 0;

        for(int i = 0; i < roll.length; i++) {

            boolean swapped = false;

            for(int j = roll.length - 1; j > i; j--) {

                if(roll[j] < roll[j - 1]) {


                    int temp = roll[j];
                    roll[j] = roll[j - 1];
                    roll[j - 1] = temp;

                    swapped = true;
                    count++;
                }
            }

            if(!swapped){
                break;
            }
        }

        double calculatedAvg = (Arrays.stream(marks).sum() - count) / n;

        return calculatedAvg >= avg ? 1 : 0;
    }

}
