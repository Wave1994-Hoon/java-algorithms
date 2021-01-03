package 스택;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

/*
* - 문제 설명
* 주어진 수식에 불필요한 괄호가 있지 않은지 확인하는 코드를 작성하라.
*
* - 문제 조건
* 산술적으로는 불필요하지만 이 문제에서는 이런 괄호는 유효하다고 가정한다.
*/
public class 불필요한괄호찾기 {
    public static void main(String[] args) {
        assertThat(solution("1 + (2) * 3")).isTrue();
        assertThat(solution("((1 + 2)) + 3")).isTrue();
        assertThat(solution("1 + (2 * 3)")).isFalse();
    }

    /*
    * 시간 복잡도: O(n^2)
    * 공간 복잡도: O(n)
    */
    private static boolean solution(String mathExpression) {
        Stack<Map<Integer, Character>> brackets = new Stack<>();
        char[] chars = mathExpression.toCharArray();

        Character openingBracket = '(';
        Character closingBracket = ')';

        List<Character> notNeedBracketArithmeticSymbol = Arrays.asList('+','-');

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == openingBracket) {
                Map<Integer, Character> element = new HashMap<>();
                element.put(i, chars[i]);
                brackets.push(element);
                continue;
            }

            if (chars[i] == closingBracket) {
                int closingBracketIndex = i;
                int openingBracketIndex = brackets.pop().keySet().iterator().next();;

                if (closingBracketIndex - openingBracketIndex == 2) {
                    return true;
                }

                for (int j = openingBracketIndex + 1; j < closingBracketIndex; j++) {
                    if (notNeedBracketArithmeticSymbol.contains(chars[j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
