package com.senla.dao;

import com.senla.entity.Room;

public class FileRoomDao implements IRoomDao{

    private final FileStreamWriter fileStreamWriter = new FileStreamWriter("Hotel.txt");
    private final FileStreamReader fileStreamReader = new FileStreamReader();

    @Override
    public void saveRoom(Room room) {
        fileStreamWriter.write("Запись комнаты:" + "\n");
        fileStreamWriter.write(room.toString() + "\n");
    }

    @Override
    public void deleteRoom(int number) {
        fileStreamWriter.write("Удаление комнаты:" + "\n");
        fileStreamWriter.write("Комната с номером " + number + " удалена." + "\n" + "\n");
    }

    @Override
    public void getList(String str){
        fileStreamWriter.write("Список комнат:" + "\n");
       fileStreamWriter.write(str);
    }

    @Override
    public void changeCostRoom(Room room) {
        fileStreamWriter.write("Изменение цены комнаты:" + "\n");
        fileStreamWriter.write("Изменена цена номера " + room.getNumber() + " на " + room.getCost() + "\n" + "\n");
    }

    @Override
    public void changeFixStatus(Room room) {
        fileStreamWriter.write("Изменение статуса номера:" + "\n");
        if(room.getFixStatus())
        fileStreamWriter.write("Изменён статус номера на ремонтируемый." + "\n");
        else fileStreamWriter.write("Изменён статус номера на обслуживаемый." + "\n");
    }
}
