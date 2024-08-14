package org.practices;

import java.util.ArrayList;

public class maxValueFromIntArray {

    public static void main(String[] args){
        maxValue();
        removeSrtingFromArrayList("abc");
    }

    public static void removeSrtingFromArrayList(String text){
        ArrayList<String> Al=new ArrayList<>();
        Al.add("abc");
        Al.add("cdb");
        Al.add("xyz");
        Al.add("tsx");
        System.out.println(Al);
        System.out.println(Al.contains(text));
    }

    public static void maxValue( ){
        int[] int_array={12,23,4,5,6,89,45};
        int max_int=int_array[0];
        for(int i=0; i<int_array.length;i++){
            if(int_array[i]>max_int){
                max_int=int_array[i];
            }
        }
        System.out.println(max_int);
    }
}
