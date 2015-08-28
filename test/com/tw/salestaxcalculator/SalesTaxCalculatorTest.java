package com.tw.salestaxcalculator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SalesTaxCalculatorTest {
    @Test
    public void shouldCalculateTotalTaxAsZeroIfProceIsZero() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(1, "any good", 0.0);

        assertEquals(0.0, salesTaxCalculator.calculateTotalTax(), 0.0000);
    }

    @Test
    public void shouldCalculateTotalTaxOnGivenCommodityWhichIsNotExemptedAndNotImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(1, "any good", 10.0);

        assertEquals(1.0, salesTaxCalculator.calculateTotalTax(), 0.0000);
    }

    @Test
    public void shouldCalculateTotalTaxOnGivenCommodityWhichIsNotExemptedButImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(1, "any imported good", 10.0);

        assertEquals(1.50, salesTaxCalculator.calculateTotalTax(), 0.0000);
    }

    @Test
    public void shouldCalculateTotalTaxOnGivenCommodityWhichIsExemptedAndNotImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(1, "book", 10.0);

        assertEquals(0.0, salesTaxCalculator.calculateTotalTax(), 0.0000);
    }

    @Test
    public void shouldCalculateTotalTaxOnGivenCommodityWhichIsExemptedButImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(1, "imported box of chocolates", 10.0);

        assertEquals(0.50, salesTaxCalculator.calculateTotalTax(), 0.0000);
    }

    @Test
    public void shouldReturnTotalPriceAsZeroIfPriceIsZero() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(1, "any good", 0.0);

        assertEquals(0.0, salesTaxCalculator.priceWithTax(), 0.000);
    }

    @Test
    public void shouldReturnTotalPriceOnGivenCommodityWhichIsNotExemptedAndNotImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(1, "any good", 14.99);

        assertEquals(16.49, salesTaxCalculator.priceWithTax(), 0.000);
    }

    @Test
    public void shouldReturnTotalPriceOnGivenCommodityWhichIsNotExemptedButImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(1, "any imported good", 10.0);

        assertEquals(11.50, salesTaxCalculator.priceWithTax(), 0.000);
    }

    @Test
    public void shouldReturnTotalPriceOnGivenCommodityWhichIsExemptedAndNotImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(1, "book", 10.0);

        assertEquals(10.0, salesTaxCalculator.priceWithTax(), 0.000);
    }

    @Test
    public void shouldReturnTotalPriceOnGivenCommodityWhichIsExemptedButImported() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(1, "box of imported chocolates", 11.25);

        assertEquals(11.85, salesTaxCalculator.priceWithTax(), 0.000);
    }

    @Test
    public void shouldReturnStringResultForGivenCommodity() {
        SalesTaxCalculator salesTaxCalculator = new SalesTaxCalculator(1, "box of imported chocolates", 11.25);

        assertEquals("1 box of imported chocolates: 11.85", salesTaxCalculator.returnResult());
    }
}