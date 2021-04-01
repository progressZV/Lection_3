package com.senla.services;

import com.senla.entities.IProduct;
import com.senla.entities.IProductPart;

public class AssemblyLine implements IAssemblyLine {
    private ILineStep body;
    private ILineStep engine;
    private ILineStep tower;

    public AssemblyLine(ILineStep body, ILineStep engine, ILineStep tower){
        this.body = body;
        this.engine = engine;
        this.tower = tower;
    }
    @Override
    public IProduct assembleProduct(IProduct product){
        IProductPart firstPart = body.buildProductPart();
        IProductPart secondPart = engine.buildProductPart();
        IProductPart thirdPart = tower.buildProductPart();
                product.installFirstPart(firstPart);
                product.installSecondPart(secondPart);
                product.installThirdPart(thirdPart);
                System.out.println("We created new Tank");
                return product;
    }
}
