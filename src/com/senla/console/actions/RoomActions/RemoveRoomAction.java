package com.senla.console.actions.RoomActions;

import com.senla.console.actions.IAction;
import com.senla.facade.AdministratorService;

import java.util.Scanner;

public class RemoveRoomAction implements IAction {
    @Override
    public void execute() {
        AdministratorService administratorService = new AdministratorService();

        System.out.println("Введите номер комнаты:");
        int number = new Scanner(System.in).nextInt();
        administratorService.removeRoom(number);
    }
}
