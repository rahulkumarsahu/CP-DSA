package org.practice.cpdsa.leetcode;

public class AmazonKindle {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,1,0,1,0,1,0,1};
        int n = 3;
        //findCombination(arr, arr.length, n);
        //findCombinationOne(arr, arr.length, n);
       //findCombinationTwo(arr, arr.length, n);
        int result = numberOfWays2("0101010101");
        System.out.println(result);
    }

    // this is not optimized way N^3 time complexity if n value is configurable so if we will increase n then this code
    // will not work....
    private static void findCombination(int[] arr, int length, int n) {

        for(int i = 0; i < length; i++)
            for(int j = i; j < length; j++)
                for(int k = j; k < length; k++)
                    if(arr[i] != arr[j] && arr[j] != arr[k])
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
    }
    // this is not optimized way N^2 time complexity if n value is configurable so if we will increase n then this code
    // will not work....
    private static void findCombinationOne(int[] arr, int length, int n) {

        for(int i = 0; i < length; i++) {

            int j = i + 1;
            int k = i + 2;

           while(j < length - 1 || k < length) {

               if(arr[i] != arr[j] && arr[j] != arr[k])
                   System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);

               if(k == length - 1) {
                   j++;
                   k = j + 1;
               } else if (k < length) {
                   k++;
               }
           }
        }


    }

    // this is optimized way N time complexity if n value is configurable so if we will increase n then this code
    // will work....
    private static void findCombinationTwo(int[] arr, int length, int n) {
        int i = 0;
        int j = 0;
        int m = 0;

        int[] out = new int[3];
        int previous = 0;
        boolean status = false;
        
        while(j < length) {

            if(j - i + 1 <= n) {
                if(status) {
                    out[0] = out[1];
                    out[1] = out[2];
                    out[2] = arr[j];
                } else {

                    out[m++] = arr[j];
                }
            }

            if(j - i + 1 == n) {

                m = 0;
                status = true;
                if(out[0] != out[1] && out[1] != out[2]) {
                    System.out.println(out[0] + " " + out[1] + " " + out[2]);
                }

                if(j == length - 1) {
                    i = previous + 1;
                    previous = i;
                    j = i + 1;
                }

                i++;
            }

            j++;
        }
    }

    public static int numberOfWays2(String book){

        int numOfWays = 0;

        if(book.length () < 3){
            return numOfWays;
        }

        int i = 0;
        int count1 = 0;
        int count2 = 0;

        while(i < book.length() - 2) {

            StringBuilder sb = new StringBuilder();
            sb.append (book.charAt(i));
            sb.append (book.charAt(i + count1 + 1));
            sb.append (book.charAt(i + count2 + 2));

            if ("101".equals(sb.toString()) || "010".equals(sb.toString())) {
                numOfWays++;
            }

            count2++;

            if((i + count2 + 2) == book.length()){
                count1++;
                count2 = count1;
            }

            if((i + count1 + 1) == book.length() - 1){
                i++;
                count1 = 0;
                count2 = 0;
            }
        }

        return numOfWays;
    }

}
