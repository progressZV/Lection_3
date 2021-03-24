package com.senla.classes;

import com.senla.interfaces.ILineStep;
import com.senla.interfaces.IProductPart;

public class PartLine implements IProductPart {
    private String name;

    public PartLine(String name){
        this.name = name;
        System.out.println("Изготавливаем деталь:" + name);
    }
    public String getName(){
        return name;
    }
}
