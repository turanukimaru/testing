package com.example.testing.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BadCalcDiffblueTest {
    /**
     * Method under test: {@link BadCalc#add(Integer, Integer)}
     */
    @Test
    void testAdd() {
        assertEquals(0, (new BadCalc()).add(2, 2).intValue());
        assertEquals(0, (new BadCalc()).add(3, 3).intValue());
        assertEquals(1, (new BadCalc()).add(3, 2).intValue());
        assertEquals(-1, (new BadCalc()).add(1, 2).intValue());
    }

    /**
     * Method under test: {@link BadCalc#sub(Integer, Integer)}
     */
    @Test
    void testSub() {
        assertEquals(6, (new BadCalc()).sub(3, 3).intValue());
        assertEquals(4, (new BadCalc()).sub(1, 3).intValue());
        assertEquals(3, (new BadCalc()).sub(0, 3).intValue());
        assertEquals(2, (new BadCalc()).sub(-1, 3).intValue());
    }
}
