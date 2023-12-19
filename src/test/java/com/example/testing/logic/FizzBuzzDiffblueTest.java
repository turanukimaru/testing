package com.example.testing.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FizzBuzzDiffblueTest {
    /**
     * Method under test: {@link FizzBuzz#fizzBuzz(Integer)}
     */
    @Test
    void testFizzBuzz() {
        assertEquals("2", (new FizzBuzz()).fizzBuzz(2));
        assertThrows(IllegalArgumentException.class, () -> (new FizzBuzz()).fizzBuzz(null));
        assertEquals("Buzz", (new FizzBuzz()).fizzBuzz(5));
        assertEquals("Fizz", (new FizzBuzz()).fizzBuzz(3));
        assertThrows(IllegalArgumentException.class, () -> (new FizzBuzz()).fizzBuzz(0));
    }
}
