package com.senla.application;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import com.senla.console.Builder;
import com.senla.console.MenuController;
import com.senla.console.Navigator;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {

   /* private static final String URL = "jdbc:mysql://127.0.0.1:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "TPogerilo76";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("We're in");
        }
    }*/

    public static void main(String[] args) {
      /*  Initializer initializer = new Initializer();
        initializer.initialize();*/

        MenuController menu = new MenuController(new Builder(), new Navigator());
        menu.run();
    }
}