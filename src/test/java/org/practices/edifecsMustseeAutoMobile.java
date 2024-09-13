package org.practices;

import java.util.HashMap;
import java.util.Map;

public class edifecsMustseeAutoMobile {

    public static void main(String[] args) {
        Car c1 = new Car("Tata Nexon", 1000, "Blue");
        Car c2 = new Car("Tata Nexon", 800, "Red");
        Car c3 = new Car("Tata punch", 900, "Black");

        HashMap<Integer, Car> sales = new HashMap<>();
        sales.put(100, c1);
        sales.put(200, c2);
        sales.put(300, c3);

        int count = 0;
        String carName = "Tata Nexon";

        for (Integer key : sales.keySet()) {
            Car car = sales.get(key); // Get the Car object by key
            if (car.getModel().equals(carName)) {
                count += key; // Add the key (sales count) to total if model matches
            }
        }

        System.out.println("Count of " + carName + " :" + count);

    }

    public void startEngine(){

        System.out.println("Engine Started");

    }

}

class Car{

    private String model;
    private int price;
    private String color;

    Car(String model, int price, String color){
        this.model=model;
        this.price=price;
        this.color=color;

    }
    String getModel(){
        return model;
    }
    String getColor(){
        return color;
    }
}
