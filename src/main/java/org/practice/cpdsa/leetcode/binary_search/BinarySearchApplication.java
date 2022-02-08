package org.practice.cpdsa.leetcode.binary_search;


// Revisit this question
public class BinarySearchApplication {

    public static void main(String[] args) {

        int target = 21;
        int sqrt = findSqrtUsingBinarySearch(target);
        int sqrtLongValue = findSqrtUsingBinarySearchForLongValue(target);
        System.out.println("The sqrt of target is :- " + sqrt);
        System.out.println("The sqrt longValue of target is :- " + sqrtLongValue);
        int precision = 3;
        double floatingValue = findPrecisionOfSqrt(target, precision, sqrt);
        System.out.println("The sqrt of target is floating value :- " + floatingValue);
        int[] nums = new int[]{5, 7, 7, 8, 8, 9};
        int[] output = firstAndLastPosition( nums, target);
        System.out.println("The first and last index are :- " + output[0] + " , " + output[1]);
        int count = findOccurrenceOfTarget(nums, target);
        System.out.println("The Occurrence of target is :- " + count);
        int[] arr = new int[]{5, 6, 7, 8, 4, 3, 2, 1};
        int peekOfMountain = findPeekOfMountain(arr);
        System.out.println("The Peek of Mountain is :- " + peekOfMountain);
        int[] array = new int[]{5, 6, 7, 0, 1, 2, 3, 4};
        int pivotElement = findPivotElement(array);
        System.out.println("The Pivot Element is :- " + pivotElement);
        int index = search(array, target);
        System.out.println("The index of Element is :- " + index);


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
                // Since we need floor, we update answer when mid*mid is smaller than x, and move closer to sqrt(x)
                startElement = midElement + 1;
                ans = midElement;
            } else {
                endElement = midElement - 1;
            }
        }
        return ans;
    }

    private static int search(int[] nums, int target) {

        int pivotIndex = findPivotElement(nums);
        int startIndex = 0;
        int endIndex = nums.length - 1;

        if(target >= nums[pivotIndex] &&  target <= nums[nums.length - 1]) {
            startIndex = pivotIndex;
        } else {
            endIndex = pivotIndex - 1;
        }

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if(nums[midIndex] == target) {
                return midIndex;
            } else if(nums[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return -1;
    }

    private static int findPivotElement(int[] nums) {

        int startIndex = 0;
        int endIndex = nums.length - 1;
        // here we are iterating till < because when start become y and end become y which is already calculated will
        // become infinite so removing =
       while(startIndex < endIndex) {

           int midIndex = startIndex + (endIndex - startIndex) / 2;
           // checking last element and first element greater to find the right side to search
           // if issue comes nums[midIndex] >= nums[0]
           if(nums[midIndex] >= nums[nums.length - 1] && nums[midIndex] >= nums[0]) {
               startIndex = midIndex + 1;
           } else {
               endIndex = midIndex;
           }
       }

       return startIndex;
    }

    private static int findPeekOfMountain(int[] nums) {

        int startIndex = 0;
        int endIndex = nums.length - 1;
        // here we are iterating till < because when start become y and end become y which is already calculated will
        // become infinite so removing =
        while(startIndex < endIndex) {

            int midIndex = startIndex + (endIndex - startIndex) / 2;
            // here checking < with mid to mid = 1 to find the peek of mountain
            if(nums[midIndex] < nums[midIndex + 1]) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex;
            }
        }

        return startIndex;
    }

    private static int findOccurrenceOfTarget(int[] nums, int target) {
        // this is sorted array so occurrence can be calculated by the last and first index
        return (lastOccurrence(nums, target) - firstOccurrence(nums, target)) + 1;
    }

    private static int[] firstAndLastPosition(int[] nums, int target) {

        int[] arr = new int[2];

        // To Find first occurrence
        arr[0] = firstOccurrence(nums, target);
        // To Find last occurrence
        arr[1] = lastOccurrence(nums, target);

        return arr;
    }

    private static int lastOccurrence(int[] nums, int target) {
        int ans = -1;

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while(startIndex <= endIndex) {

            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if(nums[midIndex] == target) {
                ans = midIndex;
                // here we are looking for last occurrence, and obviously we will find this  in right side of mid-value so updating
                startIndex = midIndex + 1;
            } else if(nums[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return ans;
    }

    private static int firstOccurrence(int[] nums, int target) {
        int ans = -1;

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while(startIndex <= endIndex) {

            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if(nums[midIndex] == target) {
                ans = midIndex;
                // here we are looking for first occurrence, and obviously we will find this  in left side of mid-value so updating
                endIndex = midIndex - 1;
            } else if(nums[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        return ans;
    }
}
