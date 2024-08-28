package org.practices;

import java.util.Arrays;

public class removeNumberAddItLeft {
    public static void main(String[] args){
        int[] s=new int[]{1,2,3,4,5,6,2};
        removeNum(s,4);
    }
    static void removeNum(int[] k, int i){
        int[] s=new int[k.length];
        int m=0;
        int temp=0;
        for(int l=0;l<k.length;l++){
            if(k[l]!=i){
                s[temp++]=k[l];
            }
        }

        for(int o=0;o<k.length;o++){
            if(k[o]==i){
                s[temp++]=i;
            }
        }
        System.out.println(Arrays.toString(s));
    }
}
