package org.practice.cpdsa.array;

public class PrimeNumber {

    public static void main(String[] args) {
        primeFactors(108);
    }

    private static void primeFactors(int n) {

        int c = 2;
        while (n > 1) {
            if (n % c == 0) {
                System.out.print(c + " ");
                n /= c;
            }
            else
                c++;
        }
    }
}
