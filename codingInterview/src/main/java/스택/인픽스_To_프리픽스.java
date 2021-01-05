package 스택;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;


/* 인픽스를 포스트픽스로 변환하기 */
public class 인픽스_To_프리픽스 {
    public static void main(String[] args) {
        assertThat(solution("(1+2)*3")).isEqualTo("12+3*");
    }

    /*
    * 시간복잡도: O(n)
    * 공간복잡도: O(n)
    * */
    private static String solution(String infix) {
        infix = infix.trim();
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        List<Character> symbol = Arrays.asList('+', '-', '/', '*');

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                postfix.append(c);
                continue;
            }
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
                continue;
            }
            if (symbol.contains(c)) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char c) {
        if (c == '*' || c == '/') { return 2; }
        if (c == '+' || c == '-') { return 1; }
        return 0;
    }
}
