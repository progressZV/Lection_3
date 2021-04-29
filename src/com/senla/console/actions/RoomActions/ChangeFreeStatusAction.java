package com.senla.console.actions.RoomActions;

import com.senla.console.actions.IAction;
import com.senla.facade.AdministratorService;

import java.util.Scanner;

public class ChangeFreeStatusAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        AdministratorService administratorService = new AdministratorService();

        System.out.println("Введите номер комнаты:");
        int id = scanner.nextInt();

        boolean freeStatus = true;
        System.out.println("Какой статус дать комнате:");
        System.out.println("1 - свободная. \t 2 - занятая.");
        int choice = scanner.nextInt();
        if(choice == 2)
            freeStatus = false;

        administratorService.changeFreeStatus(id, freeStatus);
    }
}
