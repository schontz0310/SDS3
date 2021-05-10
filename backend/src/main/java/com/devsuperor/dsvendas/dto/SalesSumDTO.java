package com.devsuperor.dsvendas.dto;

import com.devsuperor.dsvendas.entities.Seller;

public class SalesSumDTO {

    private String sellerName;
    private Double sellerSaleSum;

    public  SalesSumDTO(){}

    public SalesSumDTO(Seller seller, Double sellerSaleSum) {
        sellerName = seller.getName();
        this.sellerSaleSum = sellerSaleSum;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getSellerSaleSum() {
        return sellerSaleSum;
    }

    public void setSellerSaleSum(Double sellerSaleSum) {
        this.sellerSaleSum = sellerSaleSum;
    }
}
