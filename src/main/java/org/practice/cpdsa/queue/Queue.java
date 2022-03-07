package org.practice.cpdsa.queue;

import org.practice.cpdsa.stack.Stack;
import org.practice.cpdsa.stack.StackOverFlowException;
import org.practice.cpdsa.stack.StackUnderFlowException;
//        https://www.youtube.com/watch?v=_gJ3to4RyeQ&list=PLDzeHZWIZsTrhXYYtx4z8-u8zA-DzuVsj&index=10
//        Queue Reversal: https://practice.geeksforgeeks.org/pr...
//        First negative integer in every window of size K:https://practice.geeksforgeeks.org/pr...
//        Reverse first K element of Queue: https://practice.geeksforgeeks.org/pr...
//        First Non-Repeating character in stream:https://practice.geeksforgeeks.org/pr...
 //       Circular tour: https://practice.geeksforgeeks.org/pr...
 //       K Queue in Single Array:https://www.geeksforgeeks.org/efficie...
 //       Sum of min & max elements of all sub array of size K: https://www.geeksforgeeks.org/sum-min...
// https://github.com/loveBabbar/CodeHelp-DSA-Busted-Series/tree/main/Lecture061%20Queue%20Interview%20Questions
// Build Queue with two stack
// Complexity O(m) -> where m is number of operation perform in queue(en... or de...)
public class Queue<T> {

    // this will be used for enqueue so data comes it will be store in forward stack
    Stack<T> forwardStack = new Stack<>();
    // this will be used for dequeue  it will store data in reverse order
    Stack<T> reverseStack = new Stack<>();

    public boolean isFull() {
        return forwardStack.isFull() || reverseStack.isFull();

    }

    public boolean isEmpty() {
        return forwardStack.isEmpty() && reverseStack.isEmpty();
    }

    public void enqueue(T data) throws QueueOverFlowException {
        if(isFull()) {
            throw new QueueOverFlowException("Queue is Full");
        }
      try {
          // if forward stack is empty that means that the data got stored in reverse stack after dequeue
          // for dequeue we will pop forward stack and store in reverse stack so that we can pop first element FIFO
          // or else both are empty so if not empty it will pop all element from reverse stack and store in
          // forward stack and if not then simply just push the data
          if(forwardStack.isEmpty()) {
              while(!reverseStack.isEmpty()){
                  forwardStack.push(reverseStack.pop());
              }
          }
          forwardStack.push(data);
      } catch(StackOverFlowException | StackUnderFlowException se){
            throw new QueueOverFlowException("Queue is Full");

      }
    }

    public T dequeue() throws QueueUnderFlowException {
        if(isEmpty()) {
            throw new QueueUnderFlowException("Queue is Empty");
        }
        try {
            // if reverse stack is empty that means that the data got stored in forward stack after enqueue
            // for dequeue we will pop forward stack and store in reverse stack so that we can pop first element FIFO
            if(reverseStack.isEmpty()) {
                while(!forwardStack.isEmpty()) {
                    reverseStack.push(forwardStack.pop());
                }
            }
            return reverseStack.pop();
        } catch(StackOverFlowException | StackUnderFlowException se){
            throw new QueueUnderFlowException("Queue is Empty");

        }

    }
}
