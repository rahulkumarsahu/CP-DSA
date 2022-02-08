package org.practice.cpdsa.leetcode.binary_search;

import java.util.Arrays;
import java.util.OptionalInt;

//https://www.codingninjas.com/codestudio/problem-details/allocate-books_1090540
public class BookAllocationProblem {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40};
        int numberOfStudent = 2;
        // boolean status = isPossibleSolution(arr, 75, numberOfStudent);
        int output = bookPartition(arr, numberOfStudent);
        System.out.println("The Output is :- " + output);
    }

    private static int bookPartition(int[] arr, int numberOfStudent) {
        // here possible output can be min value from array if arr.length == number of student,
        // but it is not sorted so taking 0
        int startIndex = 0;
        // here possible output can be sum of all value from array if arr.length == 1 student,
        int endIndex = Arrays.stream(arr).sum();
        //output int output = -1;
        // handling corner case
        if(arr.length == numberOfStudent) {
            OptionalInt maxValue = Arrays.stream(arr).max();
            if(maxValue.isPresent()) {
                return maxValue.getAsInt();
            }
        } else if(numberOfStudent == 1) {
            return endIndex;
        }
        // we created search space for binary search from startIndex to endIndex
        while (startIndex <= endIndex) {
            // getting mid-index to find the solution
            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if(isPossibleSolution(arr, midIndex, numberOfStudent)) {
                //output = midIndex;
                // if midIndex is possible solution then output must be lesser than the midIndex
                endIndex = midIndex - 1;
            } else {
                // if midIndex is not possible solution then output must be greater than the midIndex
                startIndex = midIndex + 1;
            }
        }
        // return output;
        return startIndex;
    }

    private static boolean isPossibleSolution(int[] arr, int midIndex, int numberOfStudent) {

        int student = numberOfStudent;
        int index = 0;
        int sum = 0;
        // here checking index must be less than length
        while (index < arr.length) {
            // sum of array element
            sum = sum + arr[index];
            if(sum > midIndex) {
                // find the first partition for the student
                sum = 0;
                student -= 1;
            } else {
                index++;
            }
           // checking if the partition completed among student still we have book left
            // here when arr element itself is greater than midIndex value than obviously it will be false
            if(student == 0 && index < arr.length) {
                return false;
            }
        }

        return true;
    }
}
/**
 *         int studentCount = 1;
 *         int pageSum = 0;
 *
 *         for (int element : arr) {
 *             if (pageSum + element > midIndex) {
 *                 pageSum = pageSum + element;
 *             } else {
 *                 studentCount++;
 *                 if (studentCount > numberOfStudent || element > midIndex) {
 *                     return false;
 *                 }
 *                 pageSum = element;
 *             }
 *         }
 */
