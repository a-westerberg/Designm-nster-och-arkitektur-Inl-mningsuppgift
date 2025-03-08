package com.skrt.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static List<Clothing> items = new ArrayList<>();

    public static void addItem(Clothing item) {
        items.add(item);
    }

    public static List<Clothing> getItems() {
        return new ArrayList<>(items);
    }

    public static void clear(){
        items.clear();
    }

    public static boolean isEmpty(){
        return items.isEmpty();
    }
}
