package com.tw.salestaxcalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class SalesTaxCalculatorTest {
    @Test
    public void shouldCalculateTotalTaxAsZeroIfProceIsZero() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator("any good", 0.0);

        assertEquals(0.0, salesTaxCalculator.calculateTotalTax(), 0.0000);
    }

    @Test
    public void shouldCalculateTotalTaxOnGivenCommodityWhichIsNotExemptedAndNotImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator("any good", 10.0);

        assertEquals(1.0, salesTaxCalculator.calculateTotalTax(), 0.0000);
    }

    @Test
    public void shouldCalculateTotalTaxOnGivenCommodityWhichIsNotExemptedButImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator("any imported good", 10.0);

        assertEquals(1.50, salesTaxCalculator.calculateTotalTax(), 0.0000);
    }

    @Test
    public void shouldCalculateTotalTaxOnGivenCommodityWhichIsExemptedAndNotImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator("book", 10.0);

        assertEquals(0.0, salesTaxCalculator.calculateTotalTax(), 0.0000);
    }

    @Test
    public void shouldCalculateTotalTaxOnGivenCommodityWhichIsExemptedButImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator("imported box of chocolates", 10.0);

        assertEquals(0.50, salesTaxCalculator.calculateTotalTax(), 0.0000);
    }

    @Test
    public void shouldReturnTotalPriceAsZeroIfPriceIsZero() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator("any good", 0.0);

        assertEquals(0.0, salesTaxCalculator.priceWithTax(), 0.0000);
    }

    @Test
    public void shouldReturnTotalPriceOnGivenCommodityWhichIsNotExemptedAndNotImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator("any good", 10.0);

        assertEquals(11.0, salesTaxCalculator.priceWithTax(), 0.0000);
    }

    @Test
    public void shouldReturnTotalPriceOnGivenCommodityWhichIsNotExemptedButImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator("any imported good", 10.0);

        assertEquals(11.50, salesTaxCalculator.priceWithTax(), 0.0000);
    }

    @Test
    public void shouldReturnTotalPriceOnGivenCommodityWhichIsExemptedAndNotImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator("book", 10.0);

        assertEquals(10.0, salesTaxCalculator.priceWithTax(), 0.0000);
    }

    @Test
    public void shouldReturnTotalPriceOnGivenCommodityWhichIsExemptedButImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator("imported box of chocolates", 10.0);

        assertEquals(10.50, salesTaxCalculator.priceWithTax(), 0.0000);
    }
}