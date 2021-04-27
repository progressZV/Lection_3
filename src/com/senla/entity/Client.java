package com.senla.entity;

public class Client {

    private String name = null;
    private int appsNumber;

    public Client(String name, int appsNumber){
        this.name = name;
        this.appsNumber = appsNumber;
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

    public String convertToString(){
        return getName() + "\t" + getAppsNumber() + "\n";
    }
}
