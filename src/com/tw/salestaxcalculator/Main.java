package com.tw.salestaxcalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> itemList;
        double tax = 0.0, totalPrice = 0.0;
        itemList = readInput();

        for(String item: itemList){
            String[] components = getComponents(item);
            SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(Integer.parseInt(components[0]), components[1], Double.parseDouble(components[2]));
            System.out.println(salesTaxCalculator.returnResult());
            totalPrice = addTwoDoubleNumberWithTwoDigitPrecision(totalPrice, salesTaxCalculator.priceWithTax());
            tax = addTwoDoubleNumberWithTwoDigitPrecision(tax, salesTaxCalculator.calculateTotalTax());
        }
        System.out.println("Sales Taxes: " + tax);
        System.out.println("Total: " + totalPrice);
    }

    private static String[] getComponents(String item) {
        String[] itemWords = item.split(" ");
        String commodityName = "";
        for(int i = 1; i < (itemWords.length - 2); i++) {
            commodityName += itemWords[i] + " ";
        }
        return new String[]{itemWords[0], commodityName.trim(), itemWords[itemWords.length - 1]};
    }

    private static ArrayList<String> readInput() {
        ArrayList<String> itemList = new ArrayList<>();
        try {
            String item;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while(!(item=bufferedReader.readLine()).equals(" ")) {
                itemList.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    private static double addTwoDoubleNumberWithTwoDigitPrecision(double value1, double value2) {
        BigDecimal value1AsBigDecimal = BigDecimal.valueOf(value1);
        BigDecimal value2AsBigDecimal = BigDecimal.valueOf(value2);

        return value1AsBigDecimal.add(value2AsBigDecimal).doubleValue();
    }
}
