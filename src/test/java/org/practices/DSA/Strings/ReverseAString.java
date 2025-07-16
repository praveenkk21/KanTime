package org.practices.DSA.Strings;

public class ReverseAString {
    public static void main(String[] args){
        String s= "praveen";
        String reversed="";
        for(int i=0;i<s.length();i++){
            reversed= s.charAt(i)+reversed;
        }
        System.out.println(reversed);
    }
}
