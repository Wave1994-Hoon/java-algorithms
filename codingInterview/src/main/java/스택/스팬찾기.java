package 스택;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/*
* - 문제 설명
*   - 주어진 배열 prices에 대한 스팬을 구하는 코드를 작성하라.
*    - 스팬: 당일의 주가 보다 낮거나 같았던 연속적인 일 수.
*/
public class 스팬찾기 {
    public static void main(String[] args) {
        assertThat(solution(new int[]{5, 3, 2, 4, 7, 1})).isEqualTo(new int[]{1, 1, 1, 3, 5, 1});
        assertThat(solution(new int[]{2, 3, 4, 5, 6, 7})).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
    }

    /*
    * 시간 복잡도: O(N)
    * 공간 복잡도: O(N)
    */
    private static int[] solution(int[] price) {
        int[] span = new int[price.length];
        Stack<Integer> stack = new Stack<>();

        /* input 0 index info */
        stack.push(0);
        span[0] = 1;

        for (int i = 1; i < price.length; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return span;
    }
}
