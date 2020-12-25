package 배열;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/*
* 문제 설명
* - 두 수의 합
* - 숫자로 구성된 배열 numbers와 target 숫자 하나가 주어졌을 때 numbers 배열에 들어있는 두 수를 더해 target 숫자를 만들 수 있는 인덱스 두개를 찾는 함수를 작성하라.
*
* 문제 조건
* - numbers 배열에 중복되는 숫자는 없으며 target 숫자를 만들 수 있는 조합은 하나 뿐이라고 가정해도 좋다.
*/

public class 두_수의_합 {
    public static void main(String[] args) {
        assertThat(mySolution(new int[] {2,3,5,7},8)).isEqualTo(new int[] {1,2});
        assertThat(mySolution(new int[] {1,2,6,8},9)).isEqualTo(new int[] {0,3});

        assertThat(bestSolution1(new int[] {2,3,5,7},8)).isEqualTo(new int[] {1,2});
        assertThat(bestSolution1(new int[] {1,2,6,8},9)).isEqualTo(new int[] {0,3});

        assertThat(bestSolution2(new int[] {2,3,5,7},8)).isEqualTo(new int[] {1,2});
        assertThat(bestSolution2(new int[] {1,2,6,8},9)).isEqualTo(new int[] {0,3});
    }

    private static int[] mySolution(int[] numbers, int target) {
        // itar: 단축키
        for (int i = 0; i < numbers.length / 2; i ++) {
            int a = target - numbers[i];
            if (target < numbers[i]) {
                continue;
            }

            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == a) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    /*
    * 시간복잡도: O(n^2)
    * 공간복잡도: O(1)
    */
    private static int[] bestSolution1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i,j};  // 공간 복잡도: O(1)
                }
            }
        }
        return null; // 요구 사항에 따라 다름
    }

    /*
    * Hash Map 사용 -> 중복이 없고 찾아야할 값을 명확히 알 수 있음
    * 시간복잡도: O(n)
    * 공간복잡도: O(n)
    */
    private static int[] bestSolution2(int[] numbers, int target) {
        // generate Hash Map
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int numberToFind = target - numbers[i];

            if (numberMap.containsKey(numberToFind) && numberMap.get(numberToFind) != i) {
                return new int[] {i, numberMap.get(numberToFind)};
            }
            numberMap.put(numbers[i],i);

        }
        return null; // 요구 사항에 따라 다름
    }
}
