package org.practices.DSA.Arrays;

import java.util.Arrays;

public class MergeSortedArray2 {
    public static void main(String[] args){
        int[] arr1={1,2,5,6};
        int[] arr2={3,7,8,9};
        int[] mergedArray= merger(arr1, arr2);
        for(int l: mergedArray){
            System.out.println(l);
        }
    }

    public static int[] merger(int[] a, int[] b){
        int i=0;
        int j=0;
        int k=0;
        int[] result= new int[a.length+b.length];
        while(i<a.length && j< b.length){
            if(a[i]<b[j])
                result[k++]=a[i++];
            else
                result[k++]=b[j++];
        }

        while(i<a.length){
            result[k++]=a[i++];
        }

        while(j<a.length){
            result[k++]=b[j++];
        }

        return result;
    }

}
