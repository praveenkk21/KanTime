package org.practices;

import java.util.regex.*;

public class patternMatch {
    public static void main(String[] args)
    {
        String name="praveen";
        for (int i=0; i<name.length();i++){
        System.out.println(Pattern.matches("[a]",""+name.charAt(i)));
        }
        System.out.println(Pattern.matches("[amn]", "abcd"));//false (not a or m or n)
        System.out.println(Pattern.matches("[amn]", "a"));//true (among a or m or n)
        System.out.println(Pattern.matches("[amn]", "ammmna"));//false (m and a comes more than once)

    }
}
