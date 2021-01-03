package 스택;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/*
* - 문제 설명
* 괄호 수식과 여는 괄호의 위치가 주어졌을 때 그에 대응하는 닫힌 괄호의 위치를 찾는 코드를 작성하라.
*
* - 조건
* 중복되는 괄호는 없다 ex) [ ( ) ( ) ]
*/
public class 괄호_위치_찾기 {
    public static void main(String[] args) {
        assertThat(solution("[{1+2*(2+2)}-(1-3)]", 1)).isEqualTo(11);
        assertThat(solution("[{1+2*(2+2)}-(1-3)]", 0)).isEqualTo(18);
    }

    /*
    * 시간 복잡도: O(n)
    * 공간 복잡도: O(n)
    */
    private static int solution(String mathExpression, int position) {
        if (mathExpression.length() < position) {
            throw  new IllegalArgumentException("position value is over");
        }

        Stack<Character> brackets = new Stack<>();
        char[] chars = mathExpression.toCharArray();

        List<Character> openingBrackets = Arrays.asList('(','{','[');
        List<Character> closingBrackets = Arrays.asList(')','}',']');

        for (char c : chars) {
            brackets.push(c);
        }

        Character positionBracket = brackets.get(position);

        if (openingBrackets.contains(positionBracket) == false) {
            throw  new IllegalArgumentException("position value is not openingBracket");
        }

        int openingBracketIndex = openingBrackets.indexOf(positionBracket);
        Character targetClosingBracket = closingBrackets.get(openingBracketIndex);

        return brackets.indexOf(targetClosingBracket);
    }
}
