package org.practices;

import java.util.HashMap;
import java.util.TreeMap;

public class removeDuplicateWordFromString {
    public static void main(String[] args){
       removeDuplicate("Praveen is a SDET engineer and is a SDET-2");
    }

    static void removeDuplicate(String s){
        String[] k=s.split(" ");
        TreeMap<String,Integer> hp= new TreeMap<>();
        for(String l: k){
            if(hp.containsKey(l))
            {
                hp.put(l,hp.get(l)+1);
            }
            else {
                hp.put(l,1);
            }
        }
        System.out.println(hp);
    }

}
