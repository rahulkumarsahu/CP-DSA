package org.practice.cpdsa.array.basic;

public class RemoveDuplicate {

    RemoveDuplicate () {

    }
    static int[] arr = new int[]{1,1,2,2,2,3,3};
    public static void main(String[] args) {

        int result = removeDuplicate(arr);
        System.out.println(result);

        for(int i = 0; i < result; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int removeDuplicate(int[] arr) {

        int i = 0;

        for(int j = 1; j < arr.length; j++) {

            if(arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
