package greedy;

import static org.assertj.core.api.Assertions.assertThat;


/*
* 프로그래머스 Greedy 문제 Level 2, 조이스틱 문제
* url = https://programmers.co.kr/learn/courses/30/lessons/42860
*
*
*  # 문제 조건
* -----------------
* | A | A | A | A |
* -----------------
* --> up / down: A to Z 까지 문자 이동
* --> right/ left: 배열의 인덱스 이동
*
*
* # 주의사항
* A 존재 유무에 따라 좌우 최소 거리가 변할 수 있음
*
*/


public class 조이스틱 {
    public static void main(String[] args) {
        assertThat(solution("JAN")).isEqualTo(23);
        assertThat(solution("JEROEN")).isEqualTo(56);
    }

    static public int solution(String name) {
        int totalCount = 0;
        int length = name.length();

        /*
        * minDistance: 좌우로 갈 수 있는 최소 거리
        * 좌우로 최대 갈 수 있는 거리 초기화
        * 초기 값이기 때문에 가장 큰 값으로 초기화 한다.
        * 그리고 "name"에 존재하는 A의 존재 유무에 따라 값을 낮춘다.
        */
        int minDistance = length - 1;

        for(int i = 0; i<length; i++) {
            /*
            * 위아래 이동거리 계산
            * 현재 위치 기준으로 'A' 까지의 거리와 'Z' 까지의 거리를 계산 후 최소 값을 거리로 잡는다.
            */
            totalCount += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

             /*
             * A 존재 유무 체크
             * 현재 위치 기준으로 A가 존재하는지 확인한다.
             * next: 현재 위치 + 1 을 가리키며 A 가 존재한다면 +1 씩 증가 시킨다.
             */
            int indexAfterA = i + 1; // 그 다음 인덱스
            while(indexAfterA < length && name.charAt(indexAfterA) == 'A')
                indexAfterA++;

            /*
            * 좌우로 최소한으로 갈 수 있는 거리 계산
            * 현재 계산된 최소 거리와 연속된 A의 등장으로 달라진 거리를 비교
            * 2 * i: i 만큼 왔던 거리를 다시 i 만큼 되돌아 가야함 -> Right
            * length - next: 마지막 인덱스에서 A가 연속으로 나오는 지점의 다음 인덱스를 계산
            *                2 * i 만큼 되돌아 갔기 때문에 위치는 마지막 인덱스에 있다 따라서 오른쪽(<---) 기준으로 얼만큼 Right 로 이동해야되는지 체크한다.
            */
            minDistance = Math.min(minDistance, 2 * i + length - indexAfterA);
        }
        /* 위/아래 + 좌/우(minDistance) */
        totalCount += minDistance;

        return totalCount;
    }
}
