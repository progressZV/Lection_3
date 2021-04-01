package com.senla.entities;

public class Tower implements IProductPart {
    @Override
    public void printCreatedMessage() {
        System.out.println("We created tower");
    }
    public Tower(){
        printCreatedMessage();
    }
}
