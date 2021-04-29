package com.senla.console.actions.RoomActions;

import com.senla.console.actions.IAction;
import com.senla.entity.Room;
import com.senla.facade.AdministratorService;

import java.util.Scanner;

public class SaveRoomAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        AdministratorService administratorService = new AdministratorService();

        System.out.println("Введите номер комнаты:");
        int number = scanner.nextInt();
        System.out.println("Введите цену номера:");
        double cost = scanner.nextDouble();
        System.out.println("Введтие количество звёзд номера:");
        int starsCount = scanner.nextInt();
        System.out.println("Введтие количество комнат номера:");
        int roomsCount = scanner.nextInt();

        administratorService.addRoom(new Room(number, cost, starsCount, roomsCount, true, false));

    }
}
