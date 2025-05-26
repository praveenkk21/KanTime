package org.practices.DSA.Arrays;

public class MaxSubArrayKadaneAlgo {
    public static void main(String[] args){
        int[] arr={1,3,4,5,6,7};
        int k=maxSubArray(arr);
        System.out.println(k);
    }


    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];  // Initialize with the first element
        int maxSum = nums[0];      // Maximum sum found so far

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

}
