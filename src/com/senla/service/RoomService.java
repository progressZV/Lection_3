package com.senla.service;

import com.senla.entity.Room;

import java.util.List;
import java.util.Scanner;

public class RoomService {
    public String createNewRoom(List<Room> hotel){
        Room room = new Room();
        room.setFreeStatus(true);
        hotel.add(room);
        room.setNumber(hotel.size());
        return "New room added.";
    }
    public String putInTheRoom(List<Room> hotel){
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
    public String changeCost(List<Room> hotel){
        System.out.println("Цену какого номера изменить?");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        for(Room room : hotel){
            if(room.getNumber() == answer && room.getFreeStatus() == false){
                return "Данный номер занят.";
            }
            else if (room.getNumber() == answer && room.getFreeStatus() == true){
                System.out.println("Назовите цену:");
                answer = in.nextInt();
                room.setCost(answer);
                return "Цена номера изменена на " + answer;
            }
        }
        return "Данного номера не существует.";
    }
}
