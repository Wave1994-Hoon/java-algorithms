package 배열;

import static org.assertj.core.api.Assertions.assertThat;

/*
* 문제설명
* - O(n) 으로 정렬
* - 1 부터 100 까지의 숫자 중에 50개의 랜덤한 숫자가 들어있는 배열이 있다. 이 배열을 O(n)의 시간 복잡도로 정렬하라.
*
* 문제조건
* 가장 빠름 정렬 알고리즘은 O(nlogn) 이지만 문제 조건에 따라 O(n)이 가능하다.
* 배열의 인덱스 사
* */
public class 정렬 {
    public static void main(String[] args) {
        assertThat(solution(new int[] {2, 1, 5, 7})).isEqualTo(new int[] {1, 2, 5, 7});
    }

    private static int[] solution(int[] numbers) {
        boolean[] booleans = new boolean[100];

        /* 인덱스에 해당하는 값이 존재하면 true */
        for (int number : numbers) {
            booleans[number] = true;
        }

        int index = 0;

        /* 값이 true인 인덱스를 순서대로 대입 */
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                numbers[index++] = i;
            }
        }
        return numbers;
    }
}
