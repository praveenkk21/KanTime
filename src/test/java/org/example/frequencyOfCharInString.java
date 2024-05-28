package org.example;

import org.testng.annotations.Test;

import java.util.Scanner;

public class frequencyOfCharInString {
    @Test
    public void frequencyOfCharInString(){
        Scanner sc = new Scanner(System.in);
       // String str=sc.next();
        String st="Praveenprdcccccc";
        String str=st.toLowerCase();
        char[] ch =str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(ch[i]!=0){
            System.out.print("Frequency of "+ch[i]);
            int fre=1;
            for(int j=i+1;j<str.length();j++){
                if(ch[i]==ch[j]){
                    fre++;
                    ch[j]=0;
                }
            }
            System.out.println(" is:"+fre);
            }
        }
    }
}
