package test;

public class NF {

    public String solution(String T) {
        // write your code in Java SE 8

        double temperature = Double.parseDouble(T);

        if (temperature < 35.0) {
            return "hypothermia";
        }

        if (temperature >= 35.0 || temperature <= 37.5) {
            return "normal";
        }

        if (temperature > 37.5 || temperature <= 40.0) {
            return "fever";
        }

        if (temperature > 40) {
            return "hyperpyrexia";
        }

        throw new IllegalArgumentException();

    }
}
