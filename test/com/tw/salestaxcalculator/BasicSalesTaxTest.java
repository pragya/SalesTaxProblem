package com.tw.salestaxcalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicSalesTaxTest {

    @Test
    public void shouldReturnTaxAsZeroIfAmountIsZero() {
        BasicSalesTax basicSalesTax = new BasicSalesTax();

        assertEquals(0.0, basicSalesTax.calculateTax(), 0.0000);
    }
}