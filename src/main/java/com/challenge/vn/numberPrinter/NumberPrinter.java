package com.challenge.vn.numberPrinter;

import org.springframework.stereotype.Component;

@Component
public class NumberPrinter {

    public void printNumbers(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Invalid input: start number should be less than or equal to the end number.");
        }

        for (int number = start; number <= end; number++) {
            if (number % 15 == 0) {
                System.out.println("Visual Nuts");
            } else if (number % 3 == 0) {
                System.out.println("Visual");
            } else if (number % 5 == 0) {
                System.out.println("Nuts");
            } else {
                System.out.println(number);
            }
        }
    }
}
