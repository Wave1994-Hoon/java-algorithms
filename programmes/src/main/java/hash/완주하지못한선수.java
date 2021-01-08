package hash;

import java.util.HashMap;
import static org.assertj.core.api.Assertions.assertThat;

/*
* 문제
* 완주하지 못한 선수, level 1
* url = https://programmers.co.kr/learn/courses/30/lessons/42576
*
* 제한사항
* 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
* completion의 길이는 participant의 길이보다 1 작습니다.
* 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
* 참가자 중에는 동명이인이 있을 수 있습니다.
*/
public class 완주하지못한선수 {

    public static void main(String[] args) {
        assertThat(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"kiki", "eden"})).isEqualTo("leo");
        assertThat(solution(new String[] {"marina", "josipa", "nikola","vinko","filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"})).isEqualTo("vinko");
        assertThat(solution(new String[] {"mislav", "stanko", "mislav","ana"}, new String[] {"stanko", "ana", "mislav"})).isEqualTo("mislav");
    }

    /*
    * 접근법
    * HashMap 을 사용해서 접근(검색 O(1))
    * 이름은 중복될 수 있기 때문에 value 값으로 중복 체크(count 값으로 관리)
    *
    * 시간 복잡도: O(n)
    * 공간 복잡도: O(n)
    */
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> participantHashMap = new HashMap<>();

        for (String p : participant) {
            if (participantHashMap.containsKey(p)) {
                Integer count = participantHashMap.get(p);
                participantHashMap.put(p, count + 1);
                continue;
            }
            participantHashMap.put(p, 1);
        }

        for (String c : completion) {
            if (participantHashMap.containsKey(c)) {
                Integer count = participantHashMap.get(c);
                count--;

                if (count == 0) {
                    participantHashMap.remove(c);
                    continue;
                }
                participantHashMap.put(c, count);

            }
        }

        for (String p : participant) {
            if (participantHashMap.containsKey(p)) {
                answer = p;
                break;
            }
        }

        return answer;
    }
}
