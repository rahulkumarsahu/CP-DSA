package org.practice.cpdsa.stack;

public class SmallestSubsequenceDistinctCharacters {

        public String smallestSubsequence(String s) {

            int[] lastIndex = new int[26];

            for(int i = 0; i < s.length(); i++) {
                lastIndex[s.charAt(i) - 'a'] = i;
            }

            boolean[] seen = new boolean[26];

            java.util.Stack<Integer> stack = new java.util.Stack<>();
            // bba or bbab
            for(int i = 0; i < s.length(); i++) {

                int curr = s.charAt(i) - 'a';
                //
                if(seen[curr] == true) continue;

                while(!stack.isEmpty() && stack.peek() > curr && i < lastIndex[stack.peek()]) {
                    seen[stack.pop()] = false;
                    //stack.pop();
                }

                stack.push(curr);
                seen[curr] = true;

            }

            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append((char) (stack.pop() + 'a'));

            }

            return sb.reverse().toString();
        }
}
