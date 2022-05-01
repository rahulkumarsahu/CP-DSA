package org.practice.cpdsa.array;


public class EvenOdd {

    public static void main(String[] args) {

        int[] array = new int[]{2, 3, 1, 2};
        boolean status = checkIfExist(array);
        int n = checkPossiblity(10);
        System.out.println(status);
        System.out.println(n);


    }

    private static int checkPossiblity(int i) {
        return 0;
    }

    private static boolean checkIfExist(int[] nums) {

        int count = 0;

        for(int i = 0; i < nums.length; i++) {

            for(int j = 0; j < nums.length - 1; j++) {

                if(j != i && nums[j] < nums[j + 1]) count++;

            }

            if(count == nums.length - 1) return true;

        }

        return false;
    }
}
