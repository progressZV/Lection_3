package com.senla.console.actions.RoomActions;

import com.senla.console.actions.IAction;
import com.senla.facade.AdministratorService;

import java.util.Scanner;

public class ChangeCostRoomAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        AdministratorService administratorService = new AdministratorService();

        System.out.println("Введите номер комнаты:");
        int id = scanner.nextInt();
        System.out.println("Введите новую цену:");
        double cost = scanner.nextDouble();

        administratorService.changeCostRoom(id, cost);
    }
}
