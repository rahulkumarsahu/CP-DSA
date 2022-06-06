package org.practice.cpdsa.array.miscellaneous;

import java.util.Arrays;

public class TopperOfClass {

    void kTop(node[] arr, int k) {

        Arrays.sort(arr, (a, b) -> {

            if(a.marks == b.marks) return Integer.compare(a.index, b.index);

            return Integer.compare(b.marks, a.marks);
        });

        System.out.print(arr[0].index + " ");
        k--;

        for(int i = 1; i < arr.length; i++) {

            if(k >= 0) {

                if(arr[i].marks != arr[i - 1].marks) {
                    k--;
                }

                System.out.print(arr[i].index + " ");

            } else {

                break;
            }

        }

    }

    class node
    {
        int marks;
        int index;
        public void setMarks(int a)
        {
            this.marks=a;
        }
        public void setIndex(int b)
        {
            this.index=b;
        }
    }
}
