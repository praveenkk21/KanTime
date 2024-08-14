package org.practices;

import java.util.*;

public class removeDuplicateFromString {

    public static void main(String[] args) {
        String s = "pravEen";
        String sLower = s.toLowerCase();
        HashSet<Character> lists = new HashSet<>();
        int i = 0;
        for (i = 0; i < sLower.length(); i++) {
            lists.add(sLower.charAt(i));
        }
        for (Character ch:lists){
            System.out.print(ch);

        }
    }
}
