package org.practice.cpdsa;

public class CPDSAApplication {

    public static void main( String[] args ) {
       System.console();
    }

    // Time Complexity for Data Structure :-
    // 1. for calculation of time complexity always consider higher order do not consider lower order like:
    // n^2 + n or 100 -> n^2 and n * m -> nm and n + n -> n
    // O(1) < O(N) < O(N^2) < O(N^3)
    // O(N^2) + 1000 = O(N^2) for large input kind of million records we can neglect 1000
    // O(N^2) + N = O(N^2) for large input kind of million records we can neglect N
    // if we have two loops one is running n times and other is running M times O(N + M) Additive complexity
    // if we have two loops one inside another with m and n size then O(NM)
    // if one loop is running n times and inside that loop is running n/2 times then O(N*N/2) = O(N^2) division of 2 does not matter.
    // if any loop is increasing by 2 then it will be o(logN)
}
