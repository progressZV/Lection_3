package com.senla.dao;

import com.senla.entity.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCServiceDao implements IServiceDao{

    Connection connection = ConnectionDB.setConnection();

    @Override
    public void saveService(Service service) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO service VALUES(?, ?)");

            preparedStatement.setString(1, service.getName());
            preparedStatement.setDouble(2, service.getCost());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteService(String name) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM service WHERE Name=?");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void changePrice(String name, double price) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE service SET Price=? WHERE Name =?");
            preparedStatement.setDouble(1, price);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Service> getServices() {
        List<Service> services = new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM service";
            ResultSet resultSet =  statement.executeQuery(SQL);

            // парсим в java объект
            while(resultSet.next()){
                Service service = new Service();

                service.setName(resultSet.getString("Name"));
                service.setCost(resultSet.getDouble("Price"));

                services.add(service);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return services;
    }
}
