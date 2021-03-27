package com.senla.application;

import com.senla.service.*;

public class Initializer {
    public void initialize() {
        RoomService roomService = new RoomService();
        Menu menu = new Menu();
        UserInputService userInputService = new UserInputService(roomService);
        while (true) {
            var str = userInputService.menu(menu.menu());
            if (str == null) {
                break;
            }
            System.out.println(str);
        }
    }
}