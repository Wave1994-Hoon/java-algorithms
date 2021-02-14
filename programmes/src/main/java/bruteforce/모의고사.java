package bruteforce;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 모의고사 {
    public static void main(String[] args) {
        assertThat(solution(new int[] {1, 2, 3, 4, 5})).isEqualTo(new int[] {1});
        assertThat(solution(new int[] {1, 3, 2, 4, 2})).isEqualTo(new int[] {1,2,3});
    }

    public static int[] solution(int[] answers) {
        List<Integer> result = new ArrayList<>();

        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int countA = 0;
        int countB = 0;
        int countC = 0;

        for (int i = 0; i < answers.length; i++) {
            if (A[i % 5] == answers[i]) {
                countA += 1;
            }

            if (B[i % 8] == answers[i]) {
                countB += 1;
            }

            if (C[i % 10] == answers[i]) {
                countC += 1;
            }
        }

        int countMax = Math.max(countA, Math.max(countB, countC));

        if (countA == countMax) {
            result.add(1);
        }

        if (countB == countMax) {
            result.add(2);
        }

        if (countC == countMax) {
            result.add(3);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
