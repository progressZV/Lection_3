package com.senla.console.actions.ServiceActions;

import com.senla.console.actions.IAction;
import com.senla.facade.AdministratorService;

import java.util.Scanner;

public class RemoveServiceAction implements IAction {
    @Override
    public void execute() {
        AdministratorService administratorService = new AdministratorService();

        System.out.println("Введите имя сервиса:");
        String name = new Scanner(System.in).nextLine();

        administratorService.removeService(name);

    }
}
