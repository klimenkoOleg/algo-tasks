package com.oklimenko.algo;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayUtilsTest {

    @Test
    public void majorityElement() {
        assertEquals(ArrayUtils.majorityElement(new int[] { 1, 4, 2, 4, 4, 3, 4 }), 4);
    }
}
