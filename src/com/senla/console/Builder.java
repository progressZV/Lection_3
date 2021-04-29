package com.senla.console;

import com.senla.console.actions.*;
import com.senla.console.actions.ClientActions.GetClientsAction;
import com.senla.console.actions.ClientActions.RemoveClientAction;
import com.senla.console.actions.ClientActions.SaveClientAction;
import com.senla.console.actions.RoomActions.*;
import com.senla.console.actions.ServiceActions.ChangeCostService;
import com.senla.console.actions.ServiceActions.GetServicesAction;
import com.senla.console.actions.ServiceActions.RemoveServiceAction;
import com.senla.console.actions.ServiceActions.SaveServiceAction;
import com.senla.console.items.*;

public class Builder {

    private  Menu rootMenu;

    public void buildMenu() {
        Menu rootMenu = new Menu();
        rootMenu.setName("Root Menu Options:");

        MenuItem addRoom = new MenuItem("Create Room", new SaveRoomAction(), rootMenu);
        MenuItem removeRoom = new MenuItem("Remove room", new RemoveRoomAction(), rootMenu);
        MenuItem getRooms = new MenuItem("Get all rooms", new GetRoomsAction(), rootMenu);
        MenuItem changeFreeStatus = new MenuItem("Change free status for room", new ChangeFreeStatusAction(), rootMenu);
        MenuItem changeFixStatus = new MenuItem("Change fix status for room", new ChangeFixStatusAction(), rootMenu);
        MenuItem changeCostRoom = new MenuItem("Change cost for room", new ChangeCostRoomAction(), rootMenu);

        MenuItem addService = new MenuItem("Create Service", new SaveServiceAction(), rootMenu);
        MenuItem removeService = new MenuItem("Remove Service", new RemoveServiceAction(), rootMenu);
        MenuItem getServices = new MenuItem("Get all services", new GetServicesAction(), rootMenu);
        MenuItem changeCostService = new MenuItem("Change cost for service", new ChangeCostService(), rootMenu);

        MenuItem saveClient = new MenuItem("Add client in the room", new SaveClientAction(), rootMenu);
        MenuItem removeClient = new MenuItem("Remove client from room", new RemoveClientAction(), rootMenu);
        MenuItem getClients = new MenuItem("Get all clients", new GetClientsAction(), rootMenu);

        MenuItem exit = new MenuItem("Exit", new ExitAction(), rootMenu);

        rootMenu.setMenuItems(new MenuItem[] { addRoom, removeRoom, getRooms, changeFreeStatus, changeFixStatus, changeCostRoom,
                addService, removeService, getServices, changeCostService, saveClient, removeClient, getClients, exit });

        setRootMenu(rootMenu);
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    public void setRootMenu(Menu rootMenu) {
        this.rootMenu = rootMenu;
    }
}
