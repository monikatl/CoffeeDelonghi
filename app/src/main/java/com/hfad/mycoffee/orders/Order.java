package com.hfad.mycoffee.orders;


import com.hfad.mycoffee.Coffee.Coffee;

public class Order {
    String nameOfClient;
    Coffee coffee;

    public Order(String nameOfClient, Coffee coffee) {
        this.nameOfClient = nameOfClient;
        this.coffee = coffee;
    }

    public String getNameOfClient() {
        return nameOfClient;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
}
