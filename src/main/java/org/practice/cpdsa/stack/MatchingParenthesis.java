package org.practice.cpdsa.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

//complexity O(N)
public class MatchingParenthesis {

    private static final Map<Character, Character> matchingParenMap = new HashMap<>();
    private static final Set<Character> openingParenSet = new HashSet<>();

    static {
        matchingParenMap.put('}', '{');
        matchingParenMap.put(']', '[');
        matchingParenMap.put(')', '(');
        openingParenSet.addAll(matchingParenMap.values());
    }

    public static boolean hasMatchingParenthesis(String input) {
        try {
          Stack<Character> stack = new Stack<>();
          for(int i = 0; i < input.length(); i++) {
              char ch = input.charAt(i);
              // this is to check if opening bracket is present push into stack
              if(openingParenSet.contains(ch)){
                  stack.push(ch);
              }
              // this is to check if closing bracket is present then pop the bracket from stack
              if(matchingParenMap.containsKey(ch)){
                 Character lastParen = stack.pop();
                 if(!Objects.equals(matchingParenMap.get(ch), lastParen)){
                     return false;
                 }
              }
          }

          return stack.isEmpty();
        } catch(StackOverFlowException soe){
            System.err.println("Stack Overflow");

        } catch(StackUnderFlowException sue) {
            System.err.println("Stack Underflow");
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasMatchingParenthesis("(ABC){D[EF]})"));
    }
}
