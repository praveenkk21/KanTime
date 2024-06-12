package org.practices;

import java.util.HashMap;


// Java program to create a unique String using unordered_map

/* access time in unordered_map on is O(1) generally if no collisions occur
and therefore it helps us check if an element exists in a String in O(1)
time complexity with constant space. */
import java.util.*;

    public class removeDuplicateHashMap{
        // driver code
        public static void main(String[] args){
            char[] s = "praveen".toCharArray();
            int n = s.length;
            Map<Character,Integer> exists = new HashMap<>();
            String st = "";
            for(int i = 0; i < n; i++){
                if(!exists.containsKey(s[i]))
                {
                    st = st + s[i];
                    exists.put(s[i], 1);
                }
            }
            System.out.print(st.toCharArray());
        }
    }