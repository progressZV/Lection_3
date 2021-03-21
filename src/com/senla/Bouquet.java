package com.senla;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private double price;
    private List<Flower> flowers = new ArrayList<>();

    public double getPrice(){
        return price;
    }

    public Bouquet addFlower(Flower flower){
        flowers.add(flower);
        price += flower.getPrice();
        return this;
    }
}
