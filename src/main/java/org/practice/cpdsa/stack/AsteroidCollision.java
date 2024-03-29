package org.practice.cpdsa.stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        java.util.Stack<Integer> s = new java.util.Stack<>();
        for(int i: asteroids){
            if(i > 0){
                s.push(i);
            }else{// i is negative
                while(!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i)){
                    s.pop();
                }
                if(s.isEmpty() || s.peek() < 0){
                    s.push(i);
                }else if(i + s.peek() == 0){
                    s.pop(); //equal
                }
            }
        }
        int[] res = new int[s.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = s.pop();
        }
        return res;
    }
}
