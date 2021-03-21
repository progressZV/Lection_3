package com.senla;

public class Main {

    public static void main(String[] args) {
	Flower flower1 = new Flower(20);
        Flower flower2 = new Flower(30);
        Flower flower3 = new Flower(25);
        Flower flower4 = new Flower(15.5);
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(flower1).addFlower(flower2).addFlower(flower3).addFlower(flower4);
        System.out.println("Total price for bouquet:" + bouquet.getPrice());
    }
}
