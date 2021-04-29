package com.senla.console.actions.ServiceActions;

import com.senla.console.actions.IAction;
import com.senla.facade.AdministratorService;

import java.util.Scanner;

public class ChangeCostService implements IAction {
    @Override
    public void execute() {
        AdministratorService administratorService = new AdministratorService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя сервиса:");
        String name = scanner.nextLine();
        System.out.println("Введите новую цену:");
        double cost = scanner.nextDouble();

        administratorService.changeCostService(name, cost);
    }
}
