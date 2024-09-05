package org.practices;

public class swapStringsWOVar {
    public static void main(String[] args){
        String a="testABC";
        String b="test2";
        a=a+b;
        b=a.substring(0,a.length()-b.length());
        a=a.substring(b.length());
        System.out.println(b);
        System.out.println(a);

    }
}
