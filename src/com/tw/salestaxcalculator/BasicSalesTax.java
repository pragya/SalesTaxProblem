package com.tw.salestaxcalculator;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicSalesTax {
    private static final ArrayList<String> EXEMPTEDCOMMODITY = new ArrayList<>(Arrays.asList("book", "chocolate bar", "imported box of chocolates", "packet of headache pills", "box of imported chocolates"));
    private final String commodityName;
    private final double price;

    public BasicSalesTax(String commodityName, double price) {
        this.commodityName = commodityName;
        this.price = price;
    }

    public double calculateTax() {
        if(EXEMPTEDCOMMODITY.contains(commodityName)) {
            return 0.0;
        }
        return roundToNearestPointZeroFive(0.10 * price);
    }

    private double roundToNearestPointZeroFive(double amount) {
        return Math.ceil(amount * 20.0) / 20.0;
    }
}
