package week07.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitSumTest {
    @Test
    void sumOfDigitsTest(){
        assertEquals(33,DigitSum.sumOfDigits( 189654));
        assertEquals(0,DigitSum.sumOfDigits( 0));
        assertEquals(33,DigitSum.sumOfDigits( -189654));
    }

    @Test
    void sumOfDigitsWithStringTest(){
        assertEquals(33,DigitSum.sumOfDigitsWithString( 189654));
        assertEquals(0,DigitSum.sumOfDigitsWithString( 0));
        assertEquals(33,DigitSum.sumOfDigitsWithString( -189654));
    }
}