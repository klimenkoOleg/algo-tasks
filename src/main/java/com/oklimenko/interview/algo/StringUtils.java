package com.oklimenko.interview.algo;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class StringUtils {

    boolean isAnagram(String inputA, String inputB) {
        char[] charsA = inputA.toUpperCase().toCharArray();
        char[] charsB = inputB.toUpperCase().toCharArray();

        Arrays.sort(charsA);
        Arrays.sort(charsB);

        return Arrays.equals(charsA, charsB);
    }

    public String reverse(String str) {
        char[] chars = str.toCharArray();
        for (int i=0; i<chars.length/2; i++) {
            char tmp = chars[i];
            int endInd = chars.length - i - 1;
            chars[i] = chars[endInd];
            chars[endInd] = tmp;
        }
        return new String(chars);
    }

    String reverseOnlyDigital(String input) {
        char[] chars = input.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while (i<=chars.length/2 && j>=chars.length/2) {
            if (!isAlphabetical(chars[i])) {
                i++;
            } else if (!isAlphabetical(chars[j])) {
                j--;
            } else {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    public boolean isPalindrome(String str) {
        for (int i=0; i<str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphabetical(char ch) {
        return (ch>='a' && ch <= 'z') ||
                (ch>='A' && ch <= 'Z');
    }


}
