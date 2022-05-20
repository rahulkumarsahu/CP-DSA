package org.practice.cpdsa.array;

public class WeirdStock {

    public static void main(String[] args) {
        int n = 10;
        int m = 1;
        System.out.println(calculateMinimumNumberOfDays(n, m));
    }

    private static Integer calculateMinimumNumberOfDays(int n, int m) {

        int minDays = 0;

        if(n >= m) return n - m;
        else {
            for(int i = n; i > 0; i--) {

            }
            return 0;
        }
    }
}
