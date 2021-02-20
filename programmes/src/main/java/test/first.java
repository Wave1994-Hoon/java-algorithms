package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class first {

    public static void main(String[] args) {
        assertThat(solution("1234", "5678")).isEqualTo("6912");
        assertThat(solution("0000", "0000")).isEqualTo("0");
    }

    public static String solution(String a, String b) {
        int numberA = 0;
        int numberB = 0;

        for (int i = 0; i < a.length(); i++) {
            char element = a.charAt(i);
            numberA = numberA * 10 + (element - '0');
        }

        for (int i = 0; i < b.length(); i++) {
            char element = b.charAt(i);
            numberB = numberB * 10 + (element - '0');
        }

        return String.valueOf(numberA + numberB);
    }
}
