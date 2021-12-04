package sort;

import java.util.Arrays;

public class H인덱스 {

  public int solution(int[] citations) {
    int N = citations.length;
    int hIndex = 0;
    Arrays.sort(citations);
    for (int i = N - 1; i >= 0; i--) {
      if (citations[i] <= hIndex) {
        break;
      }
      hIndex++;
    }

    return hIndex;
  }
}
