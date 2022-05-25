package org.practice.cpdsa.array;

public class WeirdStock {

    public static void main(String[] args) {
        int n = 10;
        int m = 1;
        System.out.println(calculateMinimumNumberOfDays(n, m));
    }

    private static Integer calculateMinimumNumberOfDays(int n, int m) {

        int res = 0;
        // here we will start from m to n reverse and if getting odd + 1 and getting even do / 2
        // at last return res + n - m because m will be less than n, and it has to reach n by incrementing by one
        while(n < m) {

            m = (m % 2 != 0) ? m + 1 : m / 2;
            // System.out.println(m);
            res++;
        }

        return res + (n - m);
    }
}
