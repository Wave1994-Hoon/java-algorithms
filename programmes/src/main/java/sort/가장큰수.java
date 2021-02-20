package sort;

import java.util.Arrays;

public class 가장큰수 {

    public static String solution(int[] numbers) {
        int length = numbers.length;
        String[] stringNumbers = new String[length];

        for (int i = 0; i < length; i++) {
            stringNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(stringNumbers, (numberA, numberB) -> {
            if (numberA.length() == numberB.length()) {
                return numberB.compareTo(numberA);
            }
            String ab = numberA + numberB;
            String ba = numberB + numberA;
            return ba.compareTo(ab);
        });

        if ("0".equals(stringNumbers[0])) {
            return "0";
        }

        return String.join("", stringNumbers);
    }
}
