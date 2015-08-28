package com.tw.salestaxcalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicSalesTaxTest {
    @Test
    public void shouldReturnTaxAsZeroIfAmountIsZero() {
        BasicSalesTax basicSalesTax = new BasicSalesTax("", 0.0);

        assertEquals(0.0, basicSalesTax.calculateTax(), 0.0000);
    }

    @Test
    public void shouldReturnTaxAsTenPercentIfGoodIsNotExempted() {
        BasicSalesTax basicSalesTax = new BasicSalesTax("any non exempted good", 10.0);

        assertEquals(1.0, basicSalesTax.calculateTax(), 0.0000);
    }

    @Test
    public void shouldReturnTaxAsZeroIfGoodIsABookWhichIsExempted() {
        BasicSalesTax basicSalesTax = new BasicSalesTax("book", 10.0);

        assertEquals(0.0, basicSalesTax.calculateTax(), 0.0000);
    }

    @Test
    public void shouldReturnTaxAsZeroIfGoodIsAChocolateBarWhichIsExempted() {
        BasicSalesTax basicSalesTax = new BasicSalesTax("chocolate bar", 10.0);

        assertEquals(0.0, basicSalesTax.calculateTax(), 0.0000);
    }

    @Test
    public void shouldReturnTaxAsZeroIfGoodIsAImportedBoxOfChocolatesWhichIsExempted() {
        BasicSalesTax basicSalesTax = new BasicSalesTax("imported box of chocolates", 10.0);

        assertEquals(0.0, basicSalesTax.calculateTax(), 0.0000);
    }

    @Test
    public void shouldReturnTaxAsZeroIfGoodIsAPacketOfHeadachePillsWhichIsExempted() {
        BasicSalesTax basicSalesTax = new BasicSalesTax("packet of headache pills", 10.0);

        assertEquals(0.0, basicSalesTax.calculateTax(), 0.0000);
    }

    @Test
    public void shouldReturnTaxAsZeroIfGoodIsABoxOfImportedChocolatesWhichIsExempted() {
        BasicSalesTax basicSalesTax = new BasicSalesTax("box of imported chocolates", 10.0);

        assertEquals(0.0, basicSalesTax.calculateTax(), 0.0000);
    }

    @Test
    public void shouldReturnTaxAsTenPercentRoundedToNearestPointZeroFiveIfTheGoodIsNotExempted() {
        BasicSalesTax basicSalesTax = new BasicSalesTax("any non exempted good", 14.99);

        assertEquals(1.5, basicSalesTax.calculateTax(), 0.0000);
    }
}