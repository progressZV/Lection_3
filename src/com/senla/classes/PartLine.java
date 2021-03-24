package com.senla.classes;

import com.senla.interfaces.ILineStep;
import com.senla.interfaces.IProductPart;

public class PartLine implements ILineStep {
    @Override
    public IProductPart buildProductPart(String str) {
        System.out.println("Изготавливаем деталь:");
        return IProductPart;
    }
}
