package org.practices.DSA.Strings;

public class ReverseAStringArray {
    public static void main(String[]  args){
        char[] s={'a','b','c','d','e','f'};
        System.out.println(s);
        reverse(s);
    }

    public static void reverse(char[] s){
       int i=0, j=s.length-1;
       char temp;
        if(i<j){
            temp = s[i];
            s[i]=s[j];
            s[j]=temp;
        }
        System.out.println(s);
    }
}
