package com.senla.console.actions.ClientActions;

import com.senla.console.actions.IAction;
import com.senla.facade.AdministratorService;

import java.util.Scanner;

public class RemoveClientAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        AdministratorService administratorService = new AdministratorService();

        System.out.println("Введите имя клиента:");
        String name = scanner.nextLine();
        System.out.println("Введите номер комнаты клиента:");
        int id = scanner.nextInt();

        administratorService.removeClient(name, id);
    }
}
