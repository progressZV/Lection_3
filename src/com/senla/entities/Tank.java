package com.senla.entities;

public class Tank implements IProduct{
    IProductPart body;
    IProductPart engine;
    IProductPart tower;
    @Override
    public void installFirstPart(IProductPart part){
        body = part;
        System.out.println("We installed body.");
    }
    @Override
    public void installSecondPart(IProductPart part){
        engine = part;
        System.out.println("We installed engine.");
    }
    @Override
    public void installThirdPart(IProductPart part){
        tower = part;
        System.out.println("We installed tower.");
    }


}
