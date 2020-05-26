package com.hfad.mycoffee.orders;

import com.hfad.mycoffee.Coffee.Coffee;
import com.hfad.mycoffee.orders.Order;

import java.util.ArrayList;
import java.util.List;

public class ListOfOrders {

    public static List<Order> orders = new ArrayList<>();

    private static void addOrder(Order order){
        orders.add(order);
    }

    public static void makeOrder(String name, Coffee coffee){
        addOrder(new Order(name, coffee));
    }

}
