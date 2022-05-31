package com.oklimenko.interview.algo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

    @Test
    public void fizzBuzz() {
        Assertions.assertEquals(FizzBuzz.fizzBuzz(1), "1");
    }

    @Test
    public void secondTest() {
        Assertions.assertEquals(FizzBuzz.fizzBuzz(15), "12fizz4buzzfizz78fizzbuzz11fizz1314fizzbuzz");
    }
}
