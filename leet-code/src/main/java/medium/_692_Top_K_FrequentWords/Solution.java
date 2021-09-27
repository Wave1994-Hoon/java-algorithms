package medium._692_Top_K_FrequentWords;

import java.security.PublicKey;
import java.util.*;

public class Solution {
    public class WordCnt {
        String word;
        int cnt;

        public WordCnt(String word) {
            this.word = word;
            this.cnt = 1;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, WordCnt> map = new HashMap<>();
        for (String word : words) {
            if(map.containsKey(word)) {
                map.get(word).cnt++;
            } else {
                map.put(word, new WordCnt(word));
            }
        }

        PriorityQueue<WordCnt> priorityQueue = new PriorityQueue<>(
            k,
            (a,b) -> a.cnt-b.cnt != 0 ? a.cnt- b.cnt : b.word.compareTo(a.word)
        );

        for(WordCnt wordCnt: map.values()) {
            priorityQueue.offer(wordCnt);
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        List<String> answer = new ArrayList<>();
        while(!priorityQueue.isEmpty()) {
            answer.add(0, priorityQueue.poll().word);
        }
        return answer;
    }
}
