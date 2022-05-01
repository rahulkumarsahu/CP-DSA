package org.practice.cpdsa.array;

public class MaxCostPath {
    public static void main(String[] args) {

        int[] arr1 = new int[]{2, 3, 7, 10, 12};
        int[] arr2 = new int[]{1, 5, 7, 8};

        System.out.println(maxCostPath(arr1,arr2));
    }

    public static int maxCostPath(int[] arr1, int[] arr2){
        int maxCost = 0;

        int i=0, j=0;
        int arr1Cost=0, arr2Cost = 0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] == arr2[j]){
                maxCost += Math.max(arr1Cost, arr2Cost);
                arr1Cost = arr1[i++];
                arr2Cost = arr2[j++];
            }
            else if(arr1[i] > arr2[j]){
                arr2Cost += arr2[j++];
            }else{
                arr1Cost += arr1[i++];
            }

        }
        if(i<arr1.length && (arr1Cost + arr1[i]) >= arr2Cost){
            maxCost += arr1Cost;
            while(i<arr1.length ){
                maxCost += arr1[i++];
            }
        }
        else if(j<arr2.length && (arr2Cost + arr2[j]) >= arr1Cost){
            maxCost += arr2Cost;
            while(j<arr2.length ){
                maxCost += arr2[j++];
            }
        }else{
            maxCost += Math.max(arr1Cost, arr2Cost);
        }

        return maxCost;
    }
}
