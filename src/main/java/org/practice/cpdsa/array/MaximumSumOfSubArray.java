package org.practice.cpdsa.array;

import java.util.*;

public class MaximumSumOfSubArray {

    public static void main(String[] args) {

        int[] arr = new int[]{2,5,1,8,2,9,1};

        int[] arr2 = new int[]{12, -1, -7, 8, -15, 30, 18, 28};
        int[] arr1 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int target = 3;
        int output = maximumSumOfSubArray(arr, target, arr.length);
        System.out.println(output);
        firstNegativeNumber(arr2, target, arr2.length);
        List<Integer> result = maximumFromSubArray(arr1, target, arr1.length);
        System.out.println(result);
        // Longest Substring With Without Repeating Characters
        int data = longestSubStringWithUniqueCharacter();
        System.out.println(data);

        int out = longestSubString("aaabb", 3);
        System.out.println(out);
      //  int subString = minimumWindowSubstring("time to practice", "toc");
      //  System.out.println(subString);
    }

    private static int minimumWindowSubstring(String string, String target) {
        int i = 0;
        int j = 0;
        char[] ch = string.toCharArray();
        Map<Character, Integer > charMap = new HashMap<>();
        int count = target.length();
        for(int k = 0; k < target.length(); k++) {
            charMap.put(target.charAt(k), charMap.getOrDefault(target.charAt(k), 0) + 1);
        }
        int answer = -1;
        int length = ch.length;
        while (j < length) {

            if(charMap.containsKey(ch[j])) {
                charMap.put(ch[j], charMap.get(ch[j]) - 1);
                if(charMap.get(ch[j]) <= 0) count--;
                j++;
            } else if (count == 0) {
                answer = Math.max(answer, j - i + 1);
            }


        }
        return answer;
    }

    private static int longestSubString(String str, int target) {
        int i = 0;
        int j = 0;
        char[] ch = str.toCharArray();
        Map<Character, Integer > charMap = new HashMap<>();
        int answer = -1;
        int length = ch.length;
        while (j < length) {

            charMap.put(ch[j], charMap.getOrDefault(ch[j], 0) + 1);

            if(charMap.size() < target) {
                j++;
            } else if (charMap.size() == target) {
                answer = Math.max(answer, j - i + 1);
                j++;
            } else {
                while (charMap.size() > target) {
                    charMap.put(ch[i],  charMap.get(ch[i]) - 1);
                    if(charMap.get(ch[i]) == 0) {
                        charMap.remove(ch[i]);
                    }
                    i++;
                }
            }

            j++;

        }

        return answer;
    }

    private static int longestSubStringWithUniqueCharacter() {
        int i = 0;
        int j = 0;
        char[] ch = "meayl".toCharArray();
        Map<Character, Integer > charMap = new HashMap<>();
        int answer = -1;
        int length = ch.length;
        while (j < length) {

            charMap.put(ch[j], charMap.getOrDefault(ch[j], 0) + 1);
           // j - i + 1 why? we want max sub array with all unique character. so, it will depend on window size.
           if(charMap.size() == j - i + 1) {
                answer = Math.max(answer, j - i + 1);
            } else if(charMap.size() < j - i + 1) {
                while (charMap.size() < j - i + 1) {
                    charMap.put(ch[i],  charMap.get(ch[i]) - 1);
                    if(charMap.get(ch[i]) == 0) {
                        charMap.remove(ch[i]);
                    }
                    i++;
                }
            }

           j++;

        }

        return answer;
    }

    private static List<Integer> maximumFromSubArray(int[] arr1, int target, int length) {
        int i=0;
        int j=0;
        List<Integer> result = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        while (j < length) {
            int k = result.size();
            // here if we got arr[j] as max so removing other values added in list because we are considering result[0] as max
            while(!result.isEmpty() && result.get(k - 1) < arr1[j]) {
                result.remove(k - 1);
                k--;
            }
            // adding all values in list
            result.add(arr1[j]);
            // slide the window j from 0 to target
            if ( j - i + 1 < target)
                j++;
            else if (j - i + 1 == target) {
                // if we got our window then add 0 index element into output and if arr[i] matches to head value of list
                // then remove the head element to clear previous data because next window arr[i] will not be part of window
                int data = result.get(0);
                answer.add(data);
                if (data == arr1[i]) {
                    result.remove(0);
                }
                i++;
                j++;
            }
        }
        return answer;
    }


    private static void firstNegativeNumber(int[] arr, int target, int n) {
        // total output = size - k + 1
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();

        while(j < n) {
            if(arr[j] < 0) {
                result.add(arr[j]);
            }
            if(j - i + 1 < target) {
                j++;
            } else if(j - i + 1 == target)  {
                if(result.isEmpty()) {
                    System.out.print(" " + 0);
                } else {
                    System.out.print(" " + result.get(0));
                    if(result.get(0) == arr[i]) {
                        result.remove(result.get(0));
                    }
                }
                i++;
                j++;
            }
        }
    }
    private static int maximumSumOfSubArray(int[] arr, int target, int n) {
         int j = 0;
         int i = 0;
         int answer = 0;
         int sum = 0;
         // to run the loop when j reaches till end
         while(j < n) {
             // window size calculation = j - i + 1
             // increase j till the window size
             sum += arr[j];
             if (j - i + 1 < target) {
                 j++;
             } else if(j - i + 1 == target) {
                 answer = Math.max(answer, sum);
                 sum -= arr[i];
                 i++;
                 j++;
             }

         }
         return answer;
    }
}

