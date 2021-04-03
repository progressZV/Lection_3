package com.senla.entity;

import java.util.Comparator;

public class RoomRoomsComparator implements Comparator<Room> {
    public int compare(Room a, Room b) {
        if (a.getRooms_count() > b.getRooms_count())
            return 1;
        else if (a.getRooms_count() < b.getRooms_count())
            return -1;
        else
            return 0;
    }
}
