package com.senla.services;

import com.senla.entities.Engine;
import com.senla.entities.IProductPart;

public class CreateEngine implements ILineStep {
    @Override
    public IProductPart buildProductPart(){
        return new Engine();
    }
}
