package org.example;

import org.testng.annotations.Test;

public class frequencyOfCharInString {
    @Test
    public void frequencyOfCharInString(){
        String str="praveenprdcccccc";
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
