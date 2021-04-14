package com.senla.service;

import com.senla.dao.*;
import com.senla.entity.*;

import java.util.*;

public class RoomService {

    private IRoomDao roomDao = new FileRoomDao();
    private final List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        if(rooms.size() == 0) {
            rooms.add(room);
            roomDao.saveRoom(room);
            return;
        }
            for (Room room1 : rooms) {
                if (room.getNumber() != room1.getNumber() && room.getFreeStatus()) {
                    rooms.add(room);
                    roomDao.saveRoom(room);
                    return;
                }
            }
            System.out.println("Номер уже существует" + "\n");
    }

    public void deleteRoom(int number) {
        if (rooms.size() > 0) {
            for (Room room : rooms) {
                if (room.getNumber() == number) {
                    rooms.remove(room);
                    roomDao.deleteRoom(number);
                    return;
                }
            }
        }
            System.out.println("Комнаты не существует." + "\n");
    }

    public void getAllRooms() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Room room : rooms) {
            stringBuilder.append(room.toString());
        }
        roomDao.getList(stringBuilder.toString() + "\n");
    }

    public void changeCostRoom(Room room, double cost) {
        for (Room room1 : rooms) {
            if (room1.getNumber() == room.getNumber()) {
                if (!room.getFreeStatus()) {
                    System.out.println("Комната занята." + "\n");
                } else {
                    if (cost == room.getCost()) {
                        System.out.println("Данная цена не отличается от имеющейся." + "\n");
                        return;
                    }
                    room.setCost(cost);
                    roomDao.changeCostRoom(room);
                    return;
                }
            } else
                System.out.println("Комнаты не существует.");
        }
    }
}
 /*   public String putInTheRoom(List<Room> hotel){
        System.out.println("В какой номер поселить?");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        for(Room room : hotel){
            if(room.getNumber() == answer && room.getFreeStatus() == true && room.getFixStatus() == false){
                room.setFreeStatus(false);
                return "Поселение прошло успешно.";
            }
            else if (room.getNumber() == answer && room.getFreeStatus() == false){
                return "Данный номер занят.";
            }
        }
        return "Данного номера не существует.";
    }
    public String removeFromRoom(List<Room> hotel){
        System.out.println("Из какого номера выселить?");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        for(Room room : hotel){
            if(room.getNumber() == answer && room.getFreeStatus() == false){
                room.setFreeStatus(true);
                return "Выселение прошло успешно.";
            }
            else if (room.getNumber() == answer && room.getFreeStatus() == true){
                return "Данный номер никем не занят.";
            }
        }
        return "Данного номера не существует.";
    }
    public String changeFixStatus(List<Room> hotel){
        System.out.println("Статус какого номера изменить?");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        for(Room room : hotel){
            if(room.getNumber() == answer && room.getFreeStatus() == false){
                return "Данный номер занят.";
            }
            else if (room.getNumber() == answer && room.getFreeStatus() == true){
                System.out.println("На какой статус изменить?\n 1 - Ремонтируемый. \t 2 - Обслуживаемый.");
                answer = in.nextInt();
                switch (answer){
                    case 1:
                        if(room.getFixStatus() == false)
                            room.setFixStatus(true);
                        else return "Данная комната уже ремонтируется.";
                        return "Статус номера изменён на ремонтируемый.";
                    case 2:
                        if(room.getFixStatus() == true)
                            room.setFixStatus(false);
                        else return "Данная комната уже обслуживается.";
                        return "Статус номера изменён на обслуживаемый.";
                    default: return "Некорректный ввод.";
                }
            }
        }
        return "Данного номера не существует.";
    }
    public String changeCost(List<Room> hotel, List<Service> services){
        System.out.println("1 - Изменить цену номера.\n 2 - Изменить цену услуги.");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        if(answer == 1) {
            System.out.println("Цену какого номера изменить?");
            answer = in.nextInt();
            for (Room room : hotel) {
                if (room.getNumber() == answer && room.getFreeStatus() == false) {
                    return "Данный номер занят.";
                } else if (room.getNumber() == answer && room.getFreeStatus() == true) {
                    System.out.println("Назовите цену:");
                    double cost = in.nextDouble();
                    if(cost == room.getCost())
                        return "Данная цена не отличается от имеющейся.";
                    room.setCost(cost);
                    return "Цена номера изменена на " + cost;
                }
            }
            return "Данного номера не существует.";
        }
        else
        {
            System.out.println("Цену какой услуги изменить?");
            String name = in.nextLine();
            for(Service service : services){
                if (service.getName() == name){
                    System.out.println("Назовите цену:");
                    answer = in.nextInt();
                    if(answer == service.getCost())
                        return "Данная цена не отличается от имеющейся.";
                    service.setCost(answer);
                    return "Цена услуги изменена на " + answer;
                }
            }
            return "Данной услуги у нас нет.";
        }
    }
    public String listNumbers(List<Room> hotel){
        StringBuilder stringBuilder = new StringBuilder();
        Comparator<Room> roomComparator = new RoomCostComparator().thenComparing(new RoomRoomsComparator()).thenComparing(new RoomStarsComparator());
        Collections.sort(hotel, roomComparator);

        System.out.println("1 - Список всех номеров.\n 2 - Список свободных номеров.");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        if (answer == 1) {
            for (Room room : hotel) {
                stringBuilder.append(room.toString());
            }
            return stringBuilder.toString();
        }
        else {
            for (Room room : hotel) {
                if (room.getFreeStatus() == true){
                    stringBuilder.append(room.toString());
                }
            }
        }
        return  stringBuilder.toString();
    }
} */
