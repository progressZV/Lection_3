package com.senla.dao;

import com.senla.entity.Room;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JDBCRoomDao implements IRoomDao{

    Connection connection = ConnectionDB.setConnection();

    @Override
    public void saveRoom(Room _room) {
        try {
            PreparedStatement preparedStatement =
            connection.prepareStatement("INSERT INTO room VALUES(?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, _room.getNumber());
            preparedStatement.setDouble(2, _room.getCost());
            preparedStatement.setInt(3, _room.getRooms_count());
            preparedStatement.setInt(4, _room.getStars_count());
            preparedStatement.setBoolean(5, _room.getFixStatus());
            preparedStatement.setBoolean(6, _room.getFreeStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteRoom(String str) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("DELETE FROM room WHERE number=?");
            preparedStatement.setInt(1, Integer.parseInt(str));
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Room> getRooms(){
        List<Room> rooms = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Room";
           ResultSet resultSet =  statement.executeQuery(SQL);

           // парсим в java объект
            while(resultSet.next()){
                Room room = new Room();

                room.setNumber(resultSet.getInt("number"));
                room.setStars_count(resultSet.getInt("stars_count"));
                room.setRooms_count(resultSet.getInt("rooms_count"));
                room.setCost(resultSet.getDouble("cost"));
                room.setFreeStatus(resultSet.getBoolean("free_status"));
                room.setFixStatus(resultSet.getBoolean("fix_status"));

                rooms.add(room);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rooms;
    }

    @Override
    public void changeCostRoom(Integer _number, double _cost) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE room SET cost=? WHERE number =?");
            preparedStatement.setDouble(1, _cost);
            preparedStatement.setInt(2, _number);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void changeFixStatus(Integer _number, boolean _fix_status) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE room SET fix_status=? WHERE number =?");
            preparedStatement.setBoolean(1, _fix_status);
            preparedStatement.setInt(2, _number);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void changeFreeStatus(Integer _number, boolean free_status) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE room SET free_status=? WHERE number =?");
            preparedStatement.setBoolean(1, free_status);
            preparedStatement.setInt(2, _number);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
