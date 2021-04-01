package com.senla.services;

import com.senla.entities.Body;
import com.senla.entities.IProductPart;

public class CreateBody implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        return new Body();
    }
}
