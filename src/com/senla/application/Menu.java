package com.senla.application;

import java.util.Scanner;

public class Menu {
    public int menu() {
        System.out.println("1 - Поселить в номер.\n" +
                "2 - Выселить из номера.\n" +
                "3 - Изменить статус номера на ремонтируемый/обслуживаемый.\n" +
                "4 - Изменить цену номера или услуги.\n" +
                "5 - Добавить номер или услугу.\n" +
                "6 - Просмотреть список номеров.\n" +
                "7 - Общее число свободных номеров или постояльцев.\n" +
                "8 - Выйти из программы.");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}