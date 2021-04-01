package com.senla.services;

import com.senla.entities.IProduct;

public interface IAssemblyLine {
    IProduct assembleProduct(IProduct product);
}
