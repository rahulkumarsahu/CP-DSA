package org.practice.cpdsa.leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class FruitBasket {
    public static void main(String[] args) {
        int[] fruits = new int[]{1,2,3,2,2};
        int target = 2;
        int output = getMaximumNumberOfTrees(fruits, target);
        System.out.println(output);
    }

    // there is fixed way to solve sliding window question with variable window size
    private static int getMaximumNumberOfTrees(int[] fruits, int target) {
        // here i and j are two variable to maintain variable window size
        // i is first pointer of window size and j is last pointer of window size
        int i = 0;
        int j;
        int answer = 0;
       // count map for each value present in fruits array
        Map<Integer, Integer> countMap = new HashMap<>();
       // condition j < length because j is last pointer of window size, so we have to check j < length condition
       for(j = 0; j < fruits.length; j++) {
           // count map with all values count...
           countMap.put(fruits[j], countMap.getOrDefault(fruits[j] , 0) + 1);
           // to get answer if count map size increases with 2
           // if size increases then we want only 2 unique fruits because we have only 2 bucket
           // so if map size increases then we have to remove previous one and proceed with new one
           // and to remove previous one we have to remove from first pointer which is i
           while (countMap.size() > target) {
               // here we are updating the count because when window moves then the fruit tree will go out of scope,
               // so we have to decrease by one because that fruit tree will go out of window
              countMap.put(fruits[i], countMap.get(fruits[i]) - 1);
              // if window size moves then we have to remove previous answer
               // so if any of the count of fruits == 0 means it is out of window so remove from map
               if(countMap.get(fruits[i]) == 0) countMap.remove(fruits[i]);
               i++;
           }
           // to get the answer we will use the window size formula
           answer = Math.max(answer, j - i + 1);
       }

       // to get window size we use formula j - i + 1;
       return answer;
    }
}
