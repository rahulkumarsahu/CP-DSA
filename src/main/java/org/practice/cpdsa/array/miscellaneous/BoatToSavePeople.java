package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;

public class BoatToSavePeople {

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1, 2},3));
    }

    public static int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;
        int count = 0;

        while(i <= j){

            if(people[i] + people[j] <= limit){
                i++;
            }
            j--;

            count++;
        }

        return count;

    }

}
