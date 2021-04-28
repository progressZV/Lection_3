package com.senla.console;

import java.io.IOException;
import com.senla.console.items.MenuItem;

public class Navigator {

    private Menu currentMenu;

    public void printMenu() {
        System.out.println(System.lineSeparator() + getCurrentMenu().getName());
        int itemOrdinalNumber = 0;
        for (MenuItem item : getCurrentMenu().getMenuItems()) {
            itemOrdinalNumber++; // array index + 1, not to confuse user with 0
            System.out.println(itemOrdinalNumber + " " + item.getTitle());
        }
    }

    public void navigate(Integer index) throws IOException {
        // validateUserInput method can be added
        MenuItem menuItem = currentMenu.getMenuItems()[index - 1];
        if (menuItem.getAction() != null) {
            menuItem.doAction();
            System.out.println("Press enter to continue"); // optional step, or a 'BackMenu' can be used here
            System.in.read();
        }
        clearConsole();
        setCurrentMenu(menuItem.getNextMenu());
        printMenu();
    }

    private void clearConsole() { // optional
        // here you can try to clean previous console output and print new menu from the
        // start
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

}
