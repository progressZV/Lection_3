package com.senla.entity;

public class Client {

    private String name = null;
    private int appsNumber;

    public Client(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppsNumber() {
        return appsNumber;
    }

    public void setAppsNumber(int appsNumber) {
        this.appsNumber = appsNumber;
    }

    @Override
    public String toString(){
        return "Клиент " + getName();
    }
}
