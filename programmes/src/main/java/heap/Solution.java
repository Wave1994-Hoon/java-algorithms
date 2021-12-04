package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

  public static void main(String[] args) {
    int[] scoville = {1, 2, 3, 9, 10, 12};
    int K = 7;

    System.out.println(new Solution().solution(scoville, K));
  }

  public int solution(int[] scoville, int K) {
    Queue<Integer> priorityQueue = new PriorityQueue<>(scoville.length);
    int count = 0;

    for (int sc : scoville) {
      priorityQueue.add(sc);
    }

    while (!priorityQueue.isEmpty()) {
      if (priorityQueue.peek() >= K) {
        return  count;
      }

      if (priorityQueue.size() < 2) {
        break;
      }

      Integer firstElement = priorityQueue.poll();
      Integer secondElement = priorityQueue.poll();
      int newElement = firstElement + (secondElement * 2);

      priorityQueue.add(newElement);
      count ++;

    }

    return -1;
  }

}
