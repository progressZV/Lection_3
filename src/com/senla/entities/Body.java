package com.senla.entities;

public class Body implements IProductPart{
    @Override
    public void printCreatedMessage() {
        System.out.println("We created body");
    }
    public Body(){
        printCreatedMessage();
    }
}
