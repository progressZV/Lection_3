package com.senla.console.actions;

import com.senla.facade.AdministratorService;

import java.util.Scanner;

public class CreateAction implements IAction{
    @Override
    public void execute() {
        System.out.println("Enter new object name: ");
        String objectName = new Scanner(System.in).nextLine();
        // your business logic layer starts here: facade.createObject(objectName)
        // facade can be created in App.class and passed here via constructor

        System.out.printf("Executed create action for object %s" + System.lineSeparator(), objectName);
    }
}
