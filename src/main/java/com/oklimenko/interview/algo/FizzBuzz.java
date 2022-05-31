package com.oklimenko.interview.algo;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FizzBuzz {
    public String fizzBuzz(int n) {
        StringBuilder grandResult = new StringBuilder();
        for (int i=1; i<=n; i++) {
            StringBuilder result = new StringBuilder();
            if (i % 3 == 0) {
                result.append("fizz");
            }
            if (i % 5 == 0) {
                result.append("buzz");
            }
            if (result.length() == 0) {
                result.append(i);
            }
            grandResult.append(result);
        }
        return grandResult.toString();
    }

}
