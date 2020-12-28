package greedy;

import static org.assertj.core.api.Assertions.assertThat;

/*
* 프로그래머스 Greedy 문제 Level 2, 큰 수 만들 문제
* url = https://programmers.co.kr/learn/courses/30/lessons/42883
* 참고 = https://eu-ne.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%81%B0-%EC%88%98-%EB%A7%8C%EB%93%A4%EA%B8%B0-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
* # 문제 접근
* 각 자리 수의 최대 값을 구함
* 조건으로는 K가 있
*/

public class 큰수만들기 {
    public static void main(String[] args) {
        assertThat(solution("1924", 2)).isEqualTo("94");
        assertThat(solution("1231234", 3)).isEqualTo("3234");
        assertThat(solution("4177252841", 4)).isEqualTo("775841");
        assertThat(solution("00000000", 4)).isEqualTo("0000");
    }

    static String solution(String number, int k) {
        StringBuilder result = new StringBuilder();
        int startIndex = 0;

        /* return 값의 길이 = number 의 길이 - k */
        for (int findIndex = 0; findIndex < number.length() - k; findIndex++) {
            char maxElement = '0';

            /*
            * i번째 자릿수가 올 수 있는 범위에서 최댓 값을 찾는다.
            * maxElement: K 범위 내에 있는 최대 값
            * startIndex: 최대 값 다음 인덱스 값, 이 값이 커질 수록 Max 값 찾는 범위가 작아짐
            *              ex) 0 to K ----> startIndex to K
            */
            for (int index = startIndex; index <= k + findIndex; index++) {
                if (maxElement >= number.charAt(index)) {
                    continue;
                }
                maxElement = number.charAt(index);
                startIndex = index + 1;
            }
            result.append(maxElement);
        }
        return result.toString();
    }
}
