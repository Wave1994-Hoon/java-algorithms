package bruteforce;

import static org.assertj.core.api.Assertions.assertThat;

/*
* URL =  https://programmers.co.kr/learn/courses/30/lessons/42842
*
* # 문제 조건
  □ □ □ □
  □ ■ ■ □
  □ □ □ □

--> X: 가로, Y: 세로
--> Yellow = X * Y
--> Brown = 2(X + Y) + 4(상하좌우 끝 점)
--> Brown' X = Yellow' X + 2
--> 위 조건을 만족하는 X, Y를 찾아야 한다.
--> Yellow = x * Y 를 만족하는 X, Y를 찾은 후 Brown 조건을 만족하는지 확인
*/

public class 카펫 {
    public static void main(String[] args) {
        assertThat(solution(10,2)).isEqualTo(new int[] {4, 3});
        assertThat(solution(8,1)).isEqualTo(new int[] {3, 3});
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};

        for (int i = 1; i < yellow+1; i++) {
            if (yellow % i == 0) {
                int j = yellow / i;

                if (2*(i + j) + 4 == brown) {
                    return new int[] {j + 2, i + 2};
                }
            }
        }
        return answer;
    }
}
