package com.senla;

import com.senla.entities.IProduct;
import com.senla.entities.Tank;
import com.senla.services.*;

public class Main {

    public static void main(String[] args) {
        IProduct product = new Tank();
        IAssemblyLine asLine= new AssemblyLine(new CreateBody(), new CreateEngine(), new CreateTower());
        asLine.assembleProduct(product);
    }
}
