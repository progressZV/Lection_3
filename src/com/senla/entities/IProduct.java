package com.senla.entities;

public interface IProduct {
    void installFirstPart(IProductPart iproductPart);
    void installSecondPart(IProductPart productType);
    void installThirdPart(IProductPart productType);
}
