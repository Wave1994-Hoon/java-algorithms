package 스택;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/*
* - 문제 설명
* 괄호 몇개를 뒤집어야 정상적인 수식을 만들 수 있는지 계산하는 코드를 작성하라.
*
* -문제 조건
* 한 가지 괄호만 사용
*
*/
public class 괄호뒤집기 {
    public static void main(String[] args) {
        assertThat(solution("{{{{}}")).isEqualTo(1);
        assertThat(solution("}}}}{}}}")).isEqualTo(3);
        assertThat(solution("{{{{")).isEqualTo(2);
    }

    /*
     * 시간 복잡도: O(n)
     * 공간 복잡도: O(n)
     */
    private static int solution(String mathExpression) {
        if (mathExpression.length() % 2 != 0) {
            throw new IllegalArgumentException("mathExpression length is odd number");
        }

        char[] chars = mathExpression.toCharArray();

        List<Character> openingBrackets = Arrays.asList('(','{','[');
        List<Character> closingBrackets = Arrays.asList(')','}',']');

        int openingBracketCount = 0;
        int closingBracketCount = 0;

        for (char c : chars) {
            if (openingBrackets.contains(c)) { openingBracketCount += 1; }
            if (closingBrackets.contains(c)) { closingBracketCount += 1; }
        }

        if (openingBrackets == closingBrackets) {
            return 0;
        }

        int reversedBracketCount = Math.abs(openingBracketCount - closingBracketCount) / 2;

        return reversedBracketCount;
    }
}
