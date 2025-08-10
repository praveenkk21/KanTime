package org.practices.DSA.Arrays;

public class SlidingWindow {
    public static void main(String[] args){
        int[] num={1,2,3,5,2,1,4};
        int k=3;
        System.out.println(maxSubArray(num,k));
    }
    public static int maxSubArray(int[] a, int k){
        int currentSum=0;
        int maxSum=0;
        for(int i=0;i<k;i++){
            currentSum=currentSum+a[i];
        }
        maxSum=currentSum;
        for(int i=k;i<a.length-k;i++){
            currentSum=currentSum-a[i-k]+a[i];
            maxSum=Math.max(maxSum,currentSum);
        }

        return maxSum;
    }

}
