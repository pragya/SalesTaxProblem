package com.tw.salestaxcalculator;

public class ImportDuty {
    private final String commodityName;
    private final Double price;

    public ImportDuty(String commodityName, Double price) {
        this.commodityName = commodityName;
        this.price = price;
    }

    public double calculateTax() {
        if(this.imported()) {
            return roundToNearestPointZeroFive((5 * price) / 100);
        }
        return 0.0;
    }

    private boolean imported() {
        return commodityName.contains("imported");
    }

    private double roundToNearestPointZeroFive(double amount) {
        return Math.round(amount * 20.0) / 20.0;
    }

}
