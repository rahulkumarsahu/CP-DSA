package org.practice.cpdsa.array.matrix;

public class ValidWord {

    public static void main(String[] args) {
        Boolean status = validWordSquare(new String[]{"ab",
                "bnrt"});
        System.out.println(status);
    }

    public static boolean validWordSquare(String[] words) {

        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {

                if(j >= words.length || words[j].length() <= i) return false;
                if(words[i].charAt(j) != words[j].charAt(i)) return false;
            }
        }

        return true;
    }
}
