package com.senla.dao;

import com.senla.entity.Client;
import com.senla.entity.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCClientDao implements IClientDao{

    Connection connection = ConnectionDB.setConnection();

    @Override
    public void saveClient(Client client) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO client VALUES(?, ?)");

            preparedStatement.setString(1, client.getName());
            preparedStatement.setDouble(2, client.getAppsNumber());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void removeClient(String name, Integer number) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM client WHERE Name=? AND Number =?");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, number);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM client";
            ResultSet resultSet =  statement.executeQuery(SQL);

            // парсим в java объект
            while(resultSet.next()){
                Client client = new Client();

                client.setName(resultSet.getString("Name"));
                client.setAppsNumber(resultSet.getInt("Number"));

                clients.add(client);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clients;
    }
}
