package org.practices;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class reverseWordInString {


    public static void main(String[] args){
        String rev="";
        String str="praveen is good";
        String[] str2=str.split(" ");
        for(int i=0;i<str2.length;i++){
            String revWord="";
            for(int j=0;j<str2[i].length();j++){
                revWord=str2[i].charAt(j)+revWord;
            }
            rev=rev+revWord+" ";
        }
        System.out.print(rev);
    }

}
