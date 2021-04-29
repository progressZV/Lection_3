package com.senla.console.actions.ClientActions;

import com.senla.console.actions.IAction;
import com.senla.entity.Client;
import com.senla.facade.AdministratorService;

import java.util.Scanner;

public class SaveClientAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        AdministratorService administratorService = new AdministratorService();

        System.out.println("Введите имя клиента:");
        String name = scanner.nextLine();
        System.out.println("Введите номер комнаты, в которую поселить клиента:");
        int id = scanner.nextInt();

        administratorService.addClient(id, new Client(name, id));
    }
}
