package com.senla.hotel.console;

public class Menu {
    private String name;
    private MenuItem[] menuItems;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }
}
