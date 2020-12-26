package 배열;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class 세_수의_합 {

    public static void main(String[] args) {
        assertThat(mySolution(new int[] {2, 3, 5, 7},10)).isEqualTo(new int[] {0, 1, 2});
        assertThat(mySolution(new int[] {2, 1, 5, 7},13)).isEqualTo(new int[] {1, 2, 3});
    }

    private static int[] mySolution(int[] numbers, int target) {
        // generate Hash Map
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            numberMap.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int numberToFind = target - numbers[i] - numbers[j];

                if (numberMap.containsKey(numberToFind)) {
                    return new int[] {i, j, numberMap.get(numberToFind)};
                }
            }
        }
        return null; // 요구 사항에 따라 다름
    }
}
