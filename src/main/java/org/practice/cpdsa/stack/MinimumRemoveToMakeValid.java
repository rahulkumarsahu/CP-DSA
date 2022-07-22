package org.practice.cpdsa.stack;

public class MinimumRemoveToMakeValid {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        java.util.Stack<Integer> st = new java.util.Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') st.add(i);
            if (sb.charAt(i) == ')') {
                if (!st.empty()) st.pop();
                else sb.setCharAt(i, '*');
            }
        }
        while (!st.empty())
            sb.setCharAt(st.pop(), '*');
        return sb.toString().replaceAll("\\*", "");
    }
}
