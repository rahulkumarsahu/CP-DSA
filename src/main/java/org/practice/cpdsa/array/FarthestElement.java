package org.practice.cpdsa.array;

public class FarthestElement {

    public static void main(String[] args) {
        int n = 5;
        getFarthestElements(new int[]{3, 1, 5, 2, 4}, n);
    }

    private static void getFarthestElements(int[] a, int n) {

            int[] min = new int[n];
            min[n - 1] = a[n - 1];

            // creating minimum array from the last
            for (int i = n - 2; i >= 0; i--) {
                min[i]= Math.min(min[i + 1], a[i]);
            }

            for (int i = 0; i < n; i++) {
                // always taking +1 low and high -1 like. 1,5 : 2,4 : 3,3
                int low = i + 1;
                int high = n - 1;
                int ans = -1;

                while (low <= high) {

                    int mid = (low + high) / 2;
                    // if min element is less than current element then increase low = mid + 1; else high = mid - 1;
                    if (min[mid] < a[i]) {
                        ans = mid;
                        low = mid + 1;
                    }
                    else
                        high = mid - 1;
                }
                System.out.print(ans + " ");
            }
    }
}
