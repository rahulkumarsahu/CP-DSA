package org.practice.cpdsa.array;

public class PascalTriangle {

    // o(N^2)
    public static void main(String[] args) {

        int row = 5;

        for(int i = 0; i < row; i++) {

            for(int space = row; space > i; space--) {
                System.out.print(" ");
            }

            int num = 1;

            for(int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num = num * ( i - j ) / ( j + 1 );
            }
            System.out.print("\n");
        }
    }
}
