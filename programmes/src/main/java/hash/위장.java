package hash;

import test.Solution;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class 위장 {

  //https://www.youtube.com/watch?v=gUOhIk-K1-o

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[][] clothes = new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

//    System.out.println(solution.solution(clothes));
  }


  public int solution(String[][] clothes) {
    int answer = 1;

    Map<String, Integer> clothesMap = new HashMap<>();

    for (String[] element : clothes) {
      String kind = element[1];
      clothesMap.put(kind, clothesMap.getOrDefault(kind, 1) + 1);
    }


    Collection<Integer> counts = clothesMap.values();
    for (Integer count : counts) {
      answer *= count;
    }

    return answer - 1; // minus all none case
  }
}
