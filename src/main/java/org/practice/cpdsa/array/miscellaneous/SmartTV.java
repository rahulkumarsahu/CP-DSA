package org.practice.cpdsa.array.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class SmartTV {

        /**
         * NlogN
         * 2^n
         * YouTube application on a Smart TV
         * TOP, BOTTOM,
         * [
         * 65 66 67 68 -> rowIndex = 0; >= 71
         * 69 70 71 72 ->
         * ]
         * 0 1 2 3
         0  * A B C D -> I  1 2 3 -> 4 - 0 = 4
         1  * E F G H -> 0  1 J 3 -> 4 - 3 = 1 -> 3 -> 2 + 1 = 3 + 1
         2  * I J K L
         3  * M N O P  -> 3 + 1 = 4
         4  * Q R S T
         5  * U V W X  -> row index and column index of current element starting point (0, 0) destination W (5, 2)  = 5 + 2 + 1 = 8
         6  * Y Z
         W to H -> current (5, 2) destination -> (1, 3) -> 5 - 1 + 3 - 2 + 1 = 6
         H to A -> current(1, 3)  destination -> (0, 0) ->  3 - 0 + 1 - 0 + 1 = 5
         A to T -> current(0, 0) destination(4, 3) -> 8



         *    starting point ()
         * 1. W -> observe next value up or down or left or right [space]?
         * 2. find minimum from all possible solution ->
         * 3. keep on adding the minimum for final input
         * SPACE
         * 8,
         *
         * Write a function which returns minimum number of clicks
         * you will have to do in order to search for a term, given the following
         * constraints:
         * - Starting point is A
         * - You can move UP, DOWN, LEFT, RIGHT
         * - You will have to click the letter as well
         * eg:
         * input       output
         * WHATFIX     43
         * O(N)
         * Position
         * row -> 65 - 71 / 4 =  6 / 4 = 1 -> row 1
         * column -> 6 % 4 -> 2
         *
         *
         */

        public static void main(String[] args) {
            String input = "WHATFIX";
            int[][] grid = new int[6][4];
            SmartTV t = new SmartTV();
            System.out.println(t.minimumNumberOfClicks(input, grid));
        }

        private Integer minimumNumberOfClicks(String input, int[][] grid) {
            Map<Character, Pair> dataMap = new HashMap<>();
            int clicks = 0;

            for(int i = 0; i < input.length(); i++) {

                int data = input.charAt(i) - 'A';
                int row = data / grid[0].length;
                int column = data % grid[0].length;
                dataMap.put(input.charAt(i), new Pair(row, column));
            }

            int m = 0;
            int n = 1;
            //WHATFIX -> A added because we have to start from A
            String updatedInput = "A".concat(input);
            while(n < updatedInput.length()) {

                Pair firstElement = dataMap.get(updatedInput.charAt(m));
                Pair secondElement = dataMap.get(updatedInput.charAt(n));
                System.out.println("First element:" + firstElement.getRowIndex() + "  " + firstElement.getColumnIndex());
                System.out.println("Second element:" + secondElement.getRowIndex() + " " + secondElement.getColumnIndex());
                clicks += Math.abs(firstElement.getRowIndex() - secondElement.getRowIndex())
                        + Math.abs(firstElement.getColumnIndex() - secondElement.getColumnIndex()) + 1;
                System.out.println(clicks);
                m++;
                n++;
            }

            return clicks;
        }

        static class Pair {
            private final Integer rowIndex;
            private final Integer columnIndex;
            public Pair(int i, int j) {
                this.rowIndex = i;
                this.columnIndex = j;
            }

            public Integer getRowIndex() {
                return rowIndex;
            }

            public Integer getColumnIndex() {
                return columnIndex;
            }

        }

}
