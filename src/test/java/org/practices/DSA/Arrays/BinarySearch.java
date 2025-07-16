package org.practices.DSA.Arrays;// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class BinarySearch {
    public static void main(String[] args) {
        int[] num={1,2,3,4,5,6};
        Scanner in=new Scanner(System.in);
        int value= in.nextInt();
        int left=0;
        int right=num.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(num[mid]==value){
                System.out.println(mid);
            }
            else if(num[mid]<value){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
    }
}