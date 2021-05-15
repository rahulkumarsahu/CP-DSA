package org.practice.cpdsa;

public class CPDSAApplication {

    public static void main( String[] args ) {
       System.console();
    }

    // 1. for calculation of time complexity always consider higher order do not consider lower order like:
    // n^2 + n or 100 -> n^2 and n * m -> nm and n + n -> n
    // 2. if loop is increasing by 2 then it will be o(logN)
}
