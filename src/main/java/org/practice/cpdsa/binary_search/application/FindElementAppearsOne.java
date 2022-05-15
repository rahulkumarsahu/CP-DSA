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
    private static Integer findElementAppearsOne(int[] a) {

        // handling corner cases
        if(a.length == 0) return -1;
        else if(a.length == 1) return a[0];

        //corner cases where unique element will be at the start or end
        if(a[0] != a[1]) {
            return a[0];
        }
        if(a[a.length-1] != a[a.length-2]){
            return a[a.length-1];
        }

        int l=0;
        int h = a.length-1;

        while(l <= h){
            int m = (l + h) / 2;

            //when unique element is in between
            if(a[m] != a[m-1] && a[m] != a[m+1]){
                return a[m];
            }
            //if unique element is not crossed,
            //a 'm' is odd, then prev element will always be same
            //b 'm' is even, then next element will always be same
            if((m % 2 == 1 && a[m] == a[m-1]) || (m % 2 == 0 && a[m] == a[m+1])){
                l = m + 1;
            }else{
                h = m - 1;
            }
        }
        //if all elements occur twice
        return -1;
    }
}
