package org.practice.cpdsa.binary_search.application;

// need clarification
public class FindElementAppearsOne {

    public static void main(String[] args) {
        // 11,22,22,34,34,57,57
        // 1 1 2 2 4 4 7 7 8 10 10
        int[] arr = new int[]{1,1,2,3,3,4,4,8,8};
        System.out.println(findElementAppearsOne(arr));
    }

    /**
     *
     */
    private static Integer findElementAppearsOne(int[] arr) {

        // handling corner cases
        if(arr.length == 0) return -1;
        else if(arr.length == 1) return arr[0];
        else if(arr[0] != arr[1]) return arr[0];
        else if(arr[arr.length - 1] != arr[arr.length - 2]) return arr[arr.length - 1];

        // other elements check already so no need to check.
        int low = 2;
        int high = arr.length - 3;


        while(low <= high) {

             // here one analysis all values come 2 times so one repeated will in even and one repeated will be in odd
            // so if we are in even position then its pair will be on odd and if it is odd then its pair will be in even

            // calculate mid element
            int mid = (low + high) / 2;

            // if mid-element is appeared only once then it should follow this two condition mid - 1 != mid && mid + 1 != mid
            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            } else if(mid % 2 != 0) {
                // if it is odd, and then it is previous one should be paired
                if(arr[mid] == arr[mid - 1]) {
                    low = mid + 1; // -> move right side because if we are in odd that means we have even numbers of element and if previous one is equal that means all are two times
                } else {
                    high = mid - 1; // -> else ......
                }
            } else {
                // if it is even, and then it is next one should be paired
                if(arr[mid] == arr[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
