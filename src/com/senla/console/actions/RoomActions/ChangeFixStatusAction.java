package com.senla.console.actions.RoomActions;

import com.senla.console.actions.IAction;
import com.senla.facade.AdministratorService;

import java.util.Scanner;

public class ChangeFixStatusAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        AdministratorService administratorService = new AdministratorService();

        System.out.println("Введите номер комнаты:");
        int id = scanner.nextInt();

        boolean fixStatus = false;
        System.out.println("Какой статус дать комнате:");
        System.out.println("1 - свободная. \t 2 - на тех.обслуживании.");
        int choice = scanner.nextInt();
        if(choice == 2)
            fixStatus = true;

        administratorService.changeFixStatus(id, fixStatus);
    }
}
