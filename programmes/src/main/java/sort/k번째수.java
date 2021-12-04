package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
 * 문제
 * k번째 수, level 1
 * url = https://programmers.co.kr/learn/courses/30/lessons/42748
 *
 * 제한사항
 * array의 길이는 1 이상 100 이하입니다.
 * array의 각 원소는 1 이상 100 이하입니다.
 * commands의 길이는 1 이상 50 이하입니다.
 * commands의 각 원소는 길이가 3입니다.
 */
public class k번째수 {

    public static void main(String[] args) {
        assertThat(solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}))
            .isEqualTo(new int[] {5, 6, 3});
    }

    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < commands.length; index++) {
            int[] command = commands[index];

            int i = command[0];
            int j = command[1];
            int k = command[2];

            List<Integer> slicedList = new ArrayList<>();

            for (int rangeIndex = i-1; rangeIndex < j; rangeIndex++) {
                slicedList.add(array[rangeIndex]);
            }
            Collections.sort(slicedList);
            result.add(slicedList.get(k-1));
        }

        return result.stream().mapToInt(Integer -> Integer).toArray();
    }
}
