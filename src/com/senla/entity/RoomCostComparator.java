package com.senla.entity;

import java.util.Comparator;

public class RoomCostComparator implements Comparator<Room> {
    public int compare(Room a, Room b) {
        if (a.getCost() > b.getCost())
            return 1;
        else if (a.getCost() < b.getCost())
            return -1;
        else
            return 0;
    }
}
