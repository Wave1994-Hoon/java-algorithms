package 배열;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/*
* 문제 설명
* - 중복 숫자 확인
* - 숫자로 구성된 배열이 주어졌을 때 그 배열에 중복된 숫자가 있는지 확인하는 함수를 작성하라. 중복된 숫자가 있다면 true 없다면 false.
*
* 확인 사항
* - 주어진 배열이 정렬이 되어 있는지 ??
* - 배열에 중복된 숫자가 여러개인지 ??
*/

public class 중복확인 {
    public static void main(String[] args) {
        assertThat(mySolution(new int[]{1,2,3,4,5,6})).isFalse();
        assertThat(mySolution(new int[]{1,1,2,2,5,1})).isTrue();

        assertThat(bestSolution1(new int[]{1,2,3,4,5,6})).isFalse();
        assertThat(bestSolution1(new int[]{1,1,2,2,5,1})).isTrue();

        assertThat(bestSolution2(new int[]{1,2,3,4,5,6})).isFalse();
        assertThat(bestSolution2(new int[]{1,1,2,2,5,1})).isTrue();
    }

    /*
    * 시간복잡도: O(n^2)
    * 공간복잡도: O(1)
    */
    private static boolean mySolution(int[] numbers) {
        boolean isDuplicate = false;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1 ; j < numbers.length; j ++) {
                if (numbers[i] == numbers[j]) {
                    isDuplicate = true;
                    break;
                }
            }
        }

        return isDuplicate;
    }

    /*
    * 정렬을 이용한 풀이 using Quick Sort
    * 시간복잡도: O(NlogN) + O(N) (생략 가능)
    * 공간복잡도: O(logN)
    */
    private static boolean bestSolution1(int[] numbers) {
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /*
     * Set 이용한 풀이
     * 해쉬의 조회는 O(1)
     * 시간복잡도: O(N)
     * 공간복잡도: O(N)
     */
    private static boolean bestSolution2(int[] numbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (int number : numbers) {
            if (numberSet.contains(number)) {
                return true;
            }
            numberSet.add(number);
        }
        return false;
    }
}
