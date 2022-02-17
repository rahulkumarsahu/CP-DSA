package org.practice.cpdsa.leetcode.array;

public class FloydsTriangle {

    // Find the duplicate number floyd cycle. leetcode
    // constraint values will always be in range of [1, length] if N = 4 then possible values are 1 2 3 2
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,9,6,9,3,8,9,7,1};
        int output = findDuplicate(arr);
        System.out.println(output);
    }

    // here the thing is to understand is the value present in array lies between 1 to N and always one duplicate will be there
    // so from above points we can say that this array will make always a cycle.
    // slow = 2 -> 9 -> 1 -> 5 -> 3 -> 6 -> 8 -> 7
    // fast = 2 -> 1 -> 3 -> 8 -> 9 -> 5 -> 6 -> 7
    // here you can check it is making a cycle and slow is moving by 1 arr[nums] and fast is moving by 2 so to make fast move by 2 we are doing arr[arr[fast]]
    // so once we got the cycle the slow travel p + c - x and fast travel p + 2c - x where p is distance from 0 to duplicate and x is distance from cycle to duplicate and c is counter in which they increased in do while loop
    // now 2slow = fast if we solve those 2 equation then we will get p = x
    // so in next iteration fast making to arr[0] and increment one by one so one time they will meet and that will be our answer.
    private static int findDuplicate(int[] arr) {

        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        fast = arr[0];

        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }


}
