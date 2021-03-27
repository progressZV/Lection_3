package com.senla.entity;

public class Room {
    private boolean freeStatus = false;
    private boolean fixStatus = false;
    private int number = 0;
    private double cost = 0;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public boolean getFreeStatus(){
        return freeStatus;
    }

    public void setFreeStatus(boolean freeStatus) {
        this.freeStatus = freeStatus;
    }

    public boolean getFixStatus() {
        return fixStatus;
    }

    public void setFixStatus(boolean fixStatus) {
        this.fixStatus = fixStatus;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
