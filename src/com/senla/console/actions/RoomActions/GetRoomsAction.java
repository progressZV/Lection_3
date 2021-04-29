package com.senla.console.actions.RoomActions;

import com.senla.console.actions.IAction;
import com.senla.facade.AdministratorService;

public class GetRoomsAction implements IAction {
    @Override
    public void execute() {
        AdministratorService administratorService = new AdministratorService();
        administratorService.checkAllRooms();
    }
}
