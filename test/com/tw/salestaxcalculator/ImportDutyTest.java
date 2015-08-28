package com.tw.salestaxcalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImportDutyTest {
    @Test
    public void shouldReturnTaxAsZeroIfAmountIsZero() {
        ImportDuty importDuty = new ImportDuty("", 0.0);

        assertEquals(0.0, importDuty.calculateTax(), 0.0000);
    }

    @Test
    public void shouldReturnTaxAsFivePercentIfGoodIsImported() {
        ImportDuty importDuty = new ImportDuty("any imported good", 10.0);

        assertEquals(0.5, importDuty.calculateTax(), 0.0000);
    }

    @Test
    public void shouldReturnTaxAsZeroIfGoodIsNotImported() {
        ImportDuty importDuty = new ImportDuty("any other good", 10.0);

        assertEquals(0.0, importDuty.calculateTax(), 0.0000);
    }

    @Test
    public void shouldReturnTaxAsFivePercentRoundedToNearestPointZeroFiveIfGoodIsImported() {
        ImportDuty importDuty = new ImportDuty("any imported good", 27.99);

        assertEquals(1.40, importDuty.calculateTax(), 0.0000);
    }
}