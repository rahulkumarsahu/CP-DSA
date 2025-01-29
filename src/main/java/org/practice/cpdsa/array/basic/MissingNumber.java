package org.practice.cpdsa.array.basic;

public class MissingNumber {

    public static void main(String[] args) {
        int [] arr = {0,1,3};

        int res = 0;

        for(int i = 0; i < arr.length; i++) {
            res = arr[i] ^ res;
        }
        System.out.println(res);
        int x = 0;
        for(int i = 0; i <= arr.length; i++) {
            x = i ^ x;
        }
        System.out.println(x);

        System.out.println(res^x);

        int [] arr1  = {4, 1, 2, 1, 2};
        res = 0;
        for(int i = 0; i < arr1.length; i++) {
            res = arr1[i] ^ res;
        }
        System.out.println(res);
    }
}
