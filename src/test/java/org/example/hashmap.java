package org.example;

import org.testng.annotations.Test;

import java.util.HashMap;

@Test
public class hashmap {
/*
    const cars = [
            "Saab",
            "Volvo",
            "BMW"
            ];
    const cars = [];
    cars[0]= "Saab";
    cars[1]= "Volvo";
    cars[2]= "BMW";

    Const cannot be modified
    const fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.pop(); remove last element
fruits.push("test") ; add new element
fruits.toString();
fruits.length();
*/


    public static void hashmap() {
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        capitalCities.get("usa");
        capitalCities.remove("Norway");
        //capitalCities.clear();
        System.out.println(capitalCities);
    }

}

