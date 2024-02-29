// file1: TestCases.java
package com.example;

import com.example.NextDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCases {

    @Test
    public void testValidDate(){
        String dateResult = NextDate.NextDate(31, 5, 2023);
        assertEquals("01/06/2023", dateResult);
    }

    @Test
    public void testIncorrectDay() {
        String dateResult = NextDate.NextDate(35, 5, 2023);
        assertEquals("Please enter a valid Date", dateResult);
    }

    @Test
    public void testIncorrectMonth() {
        String dateResult = NextDate.NextDate(31, 18, 2023);
        assertEquals("Please enter a valid Date", dateResult);
    }

    @Test
    public void testIncorrectYear() {
        String dateResult = NextDate.NextDate(31, 5, 2224);
        assertEquals("Please enter a valid Date", dateResult);
    }

    @Test
    public void testLeapYear() {
        String dateResult = NextDate.NextDate(28, 2, 2024);
        assertEquals("29/02/2024", dateResult);
    }

    @Test
    public void testNewYear() {
        String dateResult = NextDate.NextDate(31, 12, 2023);
        assertEquals("31/12/2024", dateResult);
    }

}