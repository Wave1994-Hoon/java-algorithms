package 스택;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/*
* - 문제 설명
*   - 포스트픽스로 주어진 식을 계산하는 코드를 작성하라. 수식은 사칙연산 (+, -, *, /)만 사용한다고 가정한다.
*
* - 참고
*   - 인픽스: 수식 앞 뒤로 피연산자를 두는 표기법. 예) (1 - (2 + 3)) * 5
*   - 프리픽스: 수식 뒤에 피연산자 두개를 두는 표기법. 예) *-+2315
*   - 포스트픽스: 수식을 피연산자 두개 뒤에 두는 표기법. 예) 123+-5*
*/
public class 포스트픽스_계산 {
    public static void main(String[] args) {
        assertThat(solution("52+")).isEqualTo(7);
        assertThat(solution("52-")).isEqualTo(3);
        assertThat(solution("52*")).isEqualTo(10);
        assertThat(solution("52/")).isEqualTo(2);
        assertThat(solution("521+-9*")).isEqualTo(18);
    }
    /*
    * 시간 복잡도: O(n)
    * 공간 복잡도: O(n)
    */
    private static int solution(String postfix) {
        postfix = postfix.trim();
        Stack<Integer> numbers = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                numbers.push(c - '0'); // <-- 아스키 코드 이용, numbers.push(Integer.parseInt(c + ""))
                continue;
            }

            int right = numbers.pop();
            int left = numbers.pop();

            switch (c) {
                case '+':
                    numbers.push(left + right);
                    break;
                case '-':
                    numbers.push(left - right);
                    break;
                case '*':
                    numbers.push(left * right);
                    break;
                case '/':
                    numbers.push(left / right);
                    break;
            }
        }
        return numbers.pop();
    }
}
