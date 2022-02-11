package org.practice.cpdsa.leetcode.binary_search.application;


// Revisit this question
public class FindSquareRoot {

    public static void main(String[] args) {

        int target = 21;
        int precision = 3;
        int sqrt = findSqrtUsingBinarySearch(target);
        int sqrtLongValue = findSqrtUsingBinarySearchForLongValue(target);
        double floatingValue = findPrecisionOfSqrt(target, precision, sqrt);
        System.out.println("The sqrt of target is :- " + sqrt);
        System.out.println("The sqrt longValue of target is :- " + sqrtLongValue);
        System.out.println("The sqrt of target is floating value :- " + floatingValue);
    }

    private static double findPrecisionOfSqrt(int target, int precision, int sqrt) {
        double factor = 1;
        double ans = sqrt;

        for(int i = 0; i < precision; i++) {
            factor = factor / 10;
            for(double j = ans; j * j < target; j = j + factor) {
                ans = j;
            }
        }

        return ans;
    }

    private static int findSqrtUsingBinarySearchForLongValue(int x) {

        if (x == 0) return 0;
        int start = 1;
        int end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
                return mid;
            else if (mid > x / mid)// Keep checking the left part
                end = mid;
            else
                start = mid + 1;// Keep checking the right part
        }
        return start;
    }

    private static int findSqrtUsingBinarySearch(int target) {

        int startElement = 1;
        int endElement = target;
        int ans = -1;

        while (startElement <= endElement) {

            int midElement = startElement + (endElement - startElement) / 2;
            // If x is a perfect square
            if(midElement * midElement == target) {
                ans = midElement;
                return ans;
            } else if(target > midElement * midElement) {
                // we update answer when mid*mid is smaller than x, and move closer to sqrt(x)
                // if we do not find the exact match than we have to return closest sqrt
                // to find the closest sqrt we will consider startElement as output
                startElement = midElement + 1;
                ans = midElement;
            } else {
                endElement = midElement - 1;
            }
        }
        return ans;
    }

}
