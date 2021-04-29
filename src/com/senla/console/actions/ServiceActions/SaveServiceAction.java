package com.senla.console.actions.ServiceActions;

import com.senla.console.actions.IAction;
import com.senla.entity.Service;
import com.senla.facade.AdministratorService;

import java.util.Scanner;

public class SaveServiceAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        AdministratorService administratorService = new AdministratorService();

        System.out.println("Введите название сервиса:");
        String name = scanner.nextLine();
        System.out.println("Введите цену сервиса:");
        double cost = scanner.nextDouble();

        administratorService.addService(new Service(name, cost));

    }
}
