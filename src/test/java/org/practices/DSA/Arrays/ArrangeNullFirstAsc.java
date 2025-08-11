package org.practices.DSA.Arrays;

import java.util.Comparator;
import java.util.List;

public class ArrangeNullFirstAsc {
    public static void main(String[] args){
        List<String> list= List.of("John",null,"Allen",null,"Alice");

        List<String> output=list.stream()
                .sorted(Comparator.nullsFirst(String::compareTo))
                .toList();

        System.out.print(output);
    }
}
