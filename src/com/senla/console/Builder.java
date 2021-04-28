package com.senla.console;

import com.senla.console.actions.*;
import com.senla.console.items.*;

public class Builder {

    private  Menu rootMenu;

    public void buildMenu() {
        Menu rootMenu = new Menu();
        rootMenu.setName("Root Menu Options:");

        MenuItem createObject = new MenuItem("Create object", new CreateAction(), rootMenu);
        MenuItem deleteObject = new MenuItem("Delete object", new DeleteAction(), rootMenu);
        MenuItem exit = new MenuItem("Exit", new ExitAction(), rootMenu);

        rootMenu.setMenuItems(new MenuItem[] { createObject, deleteObject, exit });
        setRootMenu(rootMenu);
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    public void setRootMenu(Menu rootMenu) {
        this.rootMenu = rootMenu;
    }
}
