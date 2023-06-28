package com.challenge.vn.numberPrinterTests;

import com.challenge.vn.numberPrinter.NumberPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberPrintFirstTest {

    @Test
    void testPrintNumbers() {
        NumberPrinter numberPrinter = new NumberPrinter();

        // Test case 1: Valid range (1 to 100)
        numberPrinter.printNumbers(1, 100);

        // Test case 2: Valid range (50 to 75)
        numberPrinter.printNumbers(50, 75);

        // Test case 3: Invalid range (start > end)
        assertThrows(IllegalArgumentException.class, () -> numberPrinter.printNumbers(100, 50));
    }
}
