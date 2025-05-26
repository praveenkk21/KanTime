package org.practices.DSA.Arrays;

class FindMaxElementInArray{
    int findMax(int[] arr, int n){
        int max =arr[0];
        for(int i=1;i<n;i++){
            if (arr[i]>max)
                max=arr[i];
        }
        return max;
    }


    public static void main(String args[]){
        FindMaxElementInArray obj = new FindMaxElementInArray();
        int arr[] = {1, 13, 5, 7, 9};
        int n = arr.length;
        System.out.println("Maximum element in the array is: " + obj.findMax(arr, n));
    }
}