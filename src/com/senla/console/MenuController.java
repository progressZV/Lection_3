package com.senla.console;

import java.util.Scanner;

public class MenuController {

    private Builder builder;
    private Navigator navigator;

    public MenuController(Builder builder, Navigator navigator) {
        this.builder = builder;
        this.navigator = navigator;
    }

    public void run() {

        builder.buildMenu(); // builds main menu and sub-menus, creates actions
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) { // waits for user input, never stops until exit action is called or error occurs
                int choice = scanner.nextInt();
                navigator.navigate(choice);
            }
        } catch (Exception e) { /// you can use try-catch inside the 'while' loop, not to terminate process in case of error
            e.printStackTrace();
        }
    }
}
