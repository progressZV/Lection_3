package com.senla.entity;

import java.util.Comparator;

public class RoomStarsComparator implements Comparator<Room> {
    public int compare(Room a, Room b) {
        if (a.getStars_count() > b.getStars_count())
            return 1;
        else if (a.getStars_count() < b.getStars_count())
            return -1;
        else
            return 0;
    }
}
