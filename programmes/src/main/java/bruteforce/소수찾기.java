package bruteforce;

import java.util.*;

public class 소수찾기 {

  public static int solution(String numbers) {
    Set<Integer> primeSet = new HashSet<>();
    List<Character> tempNum = new ArrayList<>();

    for (int r = 1; r <= numbers.length(); r++) {
      findPrime(numbers.toCharArray(), r, tempNum, primeSet);
    }

    return primeSet.size();
  }

  private static void findPrime(char[] numbers, int r, List<Character> tempNum, Set<Integer> primeSet) {
    if (tempNum.size() == r) {
      int num = 0;
      for (char ch : tempNum) {
        num *= 10;
        num += ch - '0';
      }

      if (isPrime(num)) {
        primeSet.add(num);
      }
      return;
    }

    for (int i = 0; i < numbers.length; i++) {
      char num = numbers[i];
      if (num == '#') {
        continue;
      }

      tempNum.add(num);
      numbers[i] = '#';

      findPrime(numbers, r, tempNum, primeSet);

      tempNum.remove(tempNum.size() - 1);
      numbers[i] = num;
    }
  }

  private static boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }

    for (int i = 2; i * i <= num; i++) { // i <= Math.sqrt(num);
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }

}
