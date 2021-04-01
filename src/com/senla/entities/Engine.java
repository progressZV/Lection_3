package com.senla.entities;

public class Engine implements IProductPart{
    @Override
    public void printCreatedMessage() {
        System.out.println("We created engine");
    }
    public Engine(){
        printCreatedMessage();
    }
}
