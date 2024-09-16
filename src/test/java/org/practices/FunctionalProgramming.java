package org.practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FunctionalProgramming {

    public static void main (String[] args){

        List<Integer> number= List.of(1,3,4,5,6,8,7,9);
        List<String> fruits= List.of("Cashew","banana","orange","apple");

        // find even number

        System.out.println("Traditional");
        for (int i=0;i<number.size();i++){
            if(number.get(i) % 2==0)
                System.out.println(number.get(i));
        }

        System.out.println("Functional");
        number.stream() // converting list into strem of each values
                .filter(n -> n%2==0) //Lambda expression
                .forEach(System.out::println); //looping

        //Odd Number

        System.out.println("Traditional");
        for (int i=0;i<number.size();i++){
            if(number.get(i) % 2!=0)
                System.out.println(number.get(i));
        }

        System.out.println("Functional");
        number.stream()
                .filter(n -> n%2!=0)
                .forEach(System.out::println);

        // Square of even number

        System.out.println("Traditional");
        for (int i=0;i<number.size();i++){
            if(number.get(i) % 2==0)
                System.out.println(number.get(i)*number.get(i));
        }

        System.out.println("Functional");
        number.stream()
                .filter(n -> n%2==0)
                .map(n->n*n)
                .forEach(System.out::println);

        // find the name which has an in it

        System.out.println("Traditional");
        for (int i=0;i<fruits.size();i++){
            if(fruits.get(i).contains("an"))
                System.out.println(fruits.get(i));
        }

        System.out.println("Functional");
        fruits.stream()
                .filter(n -> n.contains("an"))
                .forEach(System.out::println);

        System.out.println("Functional - optional usage");
        Optional<String> result = fruits.stream()
                .filter(n -> n.contains("man"))
                .findFirst(); // Convert to Optional

        // it is used whene nullpointer exception raises
        result.ifPresent(System.out::println);

    }


}
