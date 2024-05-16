package org.example;

import org.testng.annotations.Test;

import java.util.Arrays;

public class matchingIntArray {

    @Test
    public static void matchingIntArray(){
        int i=3;
        int[] j= {0,1,1,1,1,1,3,4,5,5};
        //int[] j=new int[10];
        int length=0;
        int res=0;
            for ( int k : j){
            if(k==i){res++;}
        }System.out.println(res);
    }
}
