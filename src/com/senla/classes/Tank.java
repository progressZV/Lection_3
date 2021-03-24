package com.senla.classes;

import com.senla.interfaces.IProduct;
import com.senla.interfaces.IProductPart;

public class Tank implements IProduct {
    IProductPart body;
    IProduct tower;
    IProduct engine;
    @Override
    public void installFirstPart(IProductPart productType){
        System.out.println("Первая деталь установлена.");
    }
    @Override
    public void installSecondPart(IProductPart productType){
        System.out.println("Вторая деталь установлена.");
    }
    @Override
    public void installThirdPart(IProductPart productType){
        System.out.println("Третья деталь установлена.");
    }
    public Tank(){

    }
}
