package org.practice.cpdsa.stack;

// Complexity O(1)
public class MinimumElement {

    // using of two stack is because of pop if someone pop the value then one variable will not work because we
    // will not have any previous data. space complexity will be more.
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    // if first value then data will be minimum or else
    // if data is greater than previous minStack value will be store at the top in minStack or else
    // if data is smaller than data will be store at the top in minStack
    public void push(int data) throws StackOverFlowException, StackUnderFlowException {
        int min = data;
        if(!minStack.isEmpty() && min > minStack.peek()){
                min = minStack.peek();
        }
        stack.push(data);
        minStack.push(min);

    }

    // if value is getting removed from main stack so remove value from the minStack also
    // because till that index min stack contains which is the minimum value
    // previous min value is retained
    public int pop() throws StackUnderFlowException {
          minStack.pop();
          return stack.pop();
    }

    public int getMinimum() throws StackUnderFlowException {
        return minStack.peek();
    }
}
