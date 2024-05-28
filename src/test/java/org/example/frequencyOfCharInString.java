package org.example;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class frequencyOfCharInString {
    @Test
    public void frequencyOfCharInString(){
        Scanner sc = new Scanner(System.in);
       // String str=sc.next();
        String st="Praveenprdcccccc";
        String str=st.toLowerCase();
        char[] ch =str.toCharArray();

        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (charFreqMap.containsKey(ch)) {
                int count = charFreqMap.get(ch);
                charFreqMap.put(ch, count + 1);
            } else {
                charFreqMap.put(ch, 1);
            }
        }
        Iterator itr=charFreqMap.keySet().iterator();

        while (itr.hasNext()) {
            Character ch2 = (Character) itr.next();
            System.out.println("Frequency of " + ch2 + " is: " + charFreqMap.get(ch2));
        }

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
