package com.oklimenko.algo;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    @Test
    void reverse() {
        String[] input = {"sdf", "asd1"};
        Arrays.stream(input).forEach(
                s -> {
                    String reverse = StringUtils.reverse(s);
                    System.out.println(reverse);
                    assertThat(reverse)
                            .isEqualTo(new StringBuffer(s).reverse().toString());
                }
        );
    }

    @Test
    void reverseOnlyDigital() {

        String[][] input = {{"sea!$hells3", "sll!$ehaes3"}};
        Arrays.stream(input).forEach(
                s -> {
                    String reverse = StringUtils.reverseOnlyDigital(s[0]);
                    System.out.println(reverse);
                    assertThat(reverse)
                            .isEqualTo(s[1]);
                }
        );
    }

    @Test
    void isAnagram() {
        assertEquals(StringUtils.isAnagram("cinema", "iceman"), true);
        assertEquals(StringUtils.isAnagram("Mary", "Army"), true);
    }

    @Test
    void isPalindrome() {
        assertEquals(true, StringUtils.isPalindrome("asd1221dsa"));
        assertEquals(false, StringUtils.isPalindrome("thisisnotapalindrome"));
    }
}


