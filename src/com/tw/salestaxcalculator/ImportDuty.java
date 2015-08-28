package com.tw.salestaxcalculator;

import java.math.BigDecimal;

public class ImportDuty {
    private final String commodityName;
    private final Double price;

    public ImportDuty(String commodityName, Double price) {
        this.commodityName = commodityName;
        this.price = price;
    }

    public double calculateTax() {
        if(!this.imported()) {
            return 0.0;
        }
        return roundToNearestPointZeroFive(0.05 * price);
    }

    private boolean imported() {
        return commodityName.contains("imported");
    }

    private double roundToNearestPointZeroFive(double amount) {
        return Math.ceil(amount * 20.0) / 20.0;
    }

}
