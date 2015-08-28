package com.tw.salestaxcalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

public class SalesTaxCalculator {
    private final String commodityName;
    private final double price;
    private final int quantity;

    public SalesTaxCalculator(int quantity, String commodityName, double price) {
        this.commodityName = commodityName;
        this.price = price;
        this.quantity = quantity;
    }

    public double calculateTotalTax() {
        BasicSalesTax basicSalesTax = new BasicSalesTax(commodityName, price);
        ImportDuty importDuty = new ImportDuty(commodityName, price);
        return addTwoDoubleNumberWithTwoDigitPrecision(basicSalesTax.calculateTax(), importDuty.calculateTax());
    }

    public double priceWithTax() {
        return addTwoDoubleNumberWithTwoDigitPrecision(price, this.calculateTotalTax());
    }

    public String returnResult() {
        return quantity + " " +commodityName + ": " + this.priceWithTax();
    }

    private double addTwoDoubleNumberWithTwoDigitPrecision(double value1, double value2) {
        BigDecimal value1AsBigDecimal = BigDecimal.valueOf(value1);
        BigDecimal value2AsBigDecimal = BigDecimal.valueOf(value2);

        return value1AsBigDecimal.add(value2AsBigDecimal).doubleValue();
    }
}
