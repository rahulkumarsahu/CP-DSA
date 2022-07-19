package org.practice.cpdsa.stack;

public class RemoveKDigits {

        public String removeKDigits(String num, int k) {

            if(k == num.length()) return "0";

            java.util.Stack<Character> st = new java.util.Stack<>();
            int i = 0;

            while(i < num.length()) {

                while(k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)) {
                    st.pop();
                    k--;
                }
                st.push(num.charAt(i));
                i++;
            }

            while(k > 0) {
                st.pop();
                k--;
            }

            StringBuilder sb = new StringBuilder();

            while(!st.isEmpty()) {
                sb.append(st.pop());
            }

            sb.reverse();

            while(sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }

            return sb.toString();

        }

}
