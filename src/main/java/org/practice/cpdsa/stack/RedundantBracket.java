package org.practice.cpdsa.stack;

public class RedundantBracket {

    public boolean redundantBracket(String s) {

        java.util.Stack<Character> st = new java.util.Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) =='-' || s.charAt(i) == '*' || s.charAt(i) == '/'){
                st.push(s.charAt(i)); //(

            }else if (s.charAt(i) == ')') {

                boolean flag = true; // redundant

                while (st.peek() != '(') { //
                    flag = false; // not redundant
                    st.pop();
                }
                if (flag == true)
                    return true;

                st.pop();
            }
        }
        return false;
    }
}
/*
// process :
scan array and push only opening and operators (,+,-,*,/
if we get closing braces, remove until we find opening
maintain flag to check redundancy.

// inp1 = ((a+b)) == redundant (extra braces) = st = (

// inp2 = (a+b-c) == not redundant  st = (+

// inp3 = (a) == redundant (no operation) st= (

// inp4 = (a+c*b)+(c)) == redudant*/