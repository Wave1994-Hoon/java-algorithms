package sort;

import test.Solution;

import java.util.Arrays;

public class 가장큰수 {

    public static void main(String[] args) {
        int[] numbers = new int[] {6, 10, 2};
        Solution solution = new Solution();
        solution.solution(numbers);
    }

    public String solution(int[] numbers) {
        int N = numbers.length;
        String[] strNumbers = new String[N];
        for (int i = 0; i < N; i++) {
            strNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strNumbers, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });

        if ("0".equals(strNumbers[0])) {
            return "0";  // To make this caee ("00000" -> "0")
        }

        return String.join("", strNumbers);
    }
}
