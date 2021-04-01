package com.senla.services;

import com.senla.entities.IProductPart;
import com.senla.entities.Tower;

    public class CreateTower implements ILineStep {
        @Override
        public IProductPart buildProductPart(){
            return new Tower();
        }
}
