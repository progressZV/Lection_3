package com.senla.entity;

import java.util.*;

public class Hotel {
    private static List<Room> hotel = null;
    private static List<Service> services = null;

    public static List<Room> getHotel(){
        if(hotel == null)
            hotel = new ArrayList<>();
        return hotel;
    }
    public static List<Service> getServices(){
        if(services == null)
            services = new ArrayList<>();
        return services;
    }
}
