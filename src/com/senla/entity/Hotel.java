package com.senla.entity;

import java.util.*;

public class Hotel {
    private static List<Room> hotel = null;

    public static List<Room> getHotel(){
        if(hotel == null)
            hotel = new ArrayList<>();
        return hotel;
    }
}
