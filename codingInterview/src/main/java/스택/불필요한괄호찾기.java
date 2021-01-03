package 스택;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;


public class 불필요한괄호찾기 {
    public static void main(String[] args) {
        assertThat(solution("1 + (2) * 3")).isTrue();
        assertThat(solution("((1 + 2)) + 3")).isTrue();
        assertThat(solution("1 + (2 * 3)")).isFalse();
    }

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
