package com.tw.salestaxcalculator;

public class SalesTaxCalculator {
    private final String commodityName;
    private final Double price;

    public SalesTaxCalculator(String commodityName, Double price) {
        this.commodityName = commodityName;
        this.price = price;
    }

    public double calculateTotalTax() {
        BasicSalesTax basicSalesTax = new BasicSalesTax(commodityName, price);
        ImportDuty importDuty = new ImportDuty(commodityName, price);
        return basicSalesTax.calculateTax() + importDuty.calculateTax();
    }

    public double priceWithTax() {
        return price + this.calculateTotalTax();
    }
}
