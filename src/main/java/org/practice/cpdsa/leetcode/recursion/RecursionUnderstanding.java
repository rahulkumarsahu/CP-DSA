package org.practice.cpdsa.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionUnderstanding {

    public static void main(String[] args) {
   //     printOneToN(3);

        List<Integer> list = printOneToN2(3);

        list.forEach(System.out::println);


    }

    private static void printOneToN(int n) {
        if( n == 0) return;
        // if we print first then make recursive call then it will start from 10 to 1
        // because we are printing n first then making recursive call, so it will print 1 to 10
       // System.out.println(n);
        printOneToN(n - 1);

        // if we print end then make recursive call then it will start from 10 to 1
        // because we are printing n end then making recursive call, so it will print 1 to 10
        System.out.println(n);
    }


    private static List<Integer> printOneToN2(int n) {
        List<Integer> list = new ArrayList<>();

        if( n == 0) return list;

        List<Integer> data = printOneToN2(n - 1);
        data.add(n);

        list.addAll(data);

      //  System.out.println(n);

        return list;
    }



}
