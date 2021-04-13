package com.senla.entity;

public class Service {
    private String name = null;
    private double cost = 0;

    public Service(String name, double cost){
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString(){
        return "Сервис " + getName() + " Цена:" +
                getCost() + "\n";
    }
}
