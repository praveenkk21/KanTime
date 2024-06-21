package org.practices;

public class sumOfElementOfArrayBasedOnConditions {
    public static void main(String[] args){
        int[] arr=new int[]{5,9,3,7,8};
        int k=12;
        int sum=0;

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1])
                sum+=arr[i];
        }
        if(arr[arr.length-1]<k)
            sum+=arr[arr.length-1];

        System.out.print(sum);
    }
}
