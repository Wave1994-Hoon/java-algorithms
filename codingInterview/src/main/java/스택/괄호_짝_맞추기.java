package 스택;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * 문제 설명
 * - 괄호 짝 맞추기
 *
 * 접근 방법: 여는 괄호만 스택에 넣은 후에 닫는 괄호랑 비교
 */
public class 괄호_짝_맞추기 {
    public static void main(String[] args) {
        assertThat(solution1("[{1 + 2 * (2 + 2)} - (1 - 3)]")).isTrue();
        assertThat(solution1("[{1 + 2 * (2 + 2)} - [1 - 3)]")).isFalse();
        assertThat(solution1("((())")).isFalse();
        assertThat(solution1("((()))")).isTrue();

        assertThat(solution2("[{1 + 2 * (2 + 2)} - (1 - 3)]")).isTrue();
        assertThat(solution2("[{1 + 2 * (2 + 2)} - [1 - 3)]")).isFalse();
        assertThat(solution2("((())")).isFalse();
        assertThat(solution2("((()))")).isTrue();
    }

    /*
    * 시간 복잡도: O(n)
    * 공간 복잡도: O(n)
    */
    private static boolean solution1(String mathExpression) {
        Stack<Character> brackets = new Stack<>();
        char[] chars = mathExpression.toCharArray();

        for (char c : chars) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    brackets.push(c);
                    break;
                case ')':
                    if (brackets.isEmpty() || brackets.pop() != '(') { return false; }
                    break;
                case '}':
                    if (brackets.isEmpty() || brackets.pop() != '{') { return false; }
                    break;
                case ']':
                    if (brackets.isEmpty() ||  brackets.pop() != '[') { return false; }
                    break;
            }
        }

        return brackets.isEmpty();
    }

    /*
    * 시간 복잡도: O(n)
    * 공간 복잡도: O(n)
    */
    private static boolean solution2(String mathExpression) {
        Stack<Character> brackets = new Stack<>();
        char[] chars = mathExpression.toCharArray();

        List<Character> openingBrackets = Arrays.asList('(','{','[');
        List<Character> closingBrackets = Arrays.asList(')','}',']');

        for (char c : chars) {
            if (openingBrackets.contains(c)) {
                brackets.push(c);
                continue;
            }
            if (closingBrackets.contains(c)) {
                if (brackets.isEmpty()) { return false; }

                int openingBracketIndex = openingBrackets.indexOf(brackets.pop());
                if (closingBrackets.indexOf(c) != openingBracketIndex) { return false; }
            }
        }
        return brackets.isEmpty();
    }
}
