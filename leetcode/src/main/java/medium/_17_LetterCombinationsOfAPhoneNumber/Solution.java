package medium._17_LetterCombinationsOfAPhoneNumber;

import java.util.*;

class Solution {
  private static final Map<Character, String> digitHashTable = new HashMap<>();
  static {
    digitHashTable.put('2', "abc");
    digitHashTable.put('3', "def");
    digitHashTable.put('4', "ghi");
    digitHashTable.put('5', "jkl");
    digitHashTable.put('6', "mno");
    digitHashTable.put('7', "pqrs");
    digitHashTable.put('8', "tuv");
    digitHashTable.put('9', "wxyz");
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.letterCombinations("235"));
  }

  public List<String> letterCombinations(String input) {
    if (input.isEmpty()) {
      return Collections.emptyList();
    }

    List<String> result = new ArrayList<>();
    char[] digits = input.toCharArray();

    process(result, digits, 0, new StringBuilder());
    return result;
  }

  private void process(List<String> result, char[] digits, int level, StringBuilder currentResult) {
    // "ab" 와 같이 문자열이 완성되면 탈출한다.
    if (level == digits.length) {
      result.add(currentResult.toString());
      return;
    }

    char[] letters = digitHashTable
        .get(digits[level])
        .toCharArray();

    for (int index = 0; index < letters.length; index++) {
      char letter = letters[index];

      currentResult.append(letter);
      process(result, digits, level + 1, currentResult); // 재귀 호출

      currentResult.deleteCharAt(currentResult.length() - 1); // "ab" 로 끝날 경우 'b' 를 제거하고 다음 탐색을 한다.
    }
  }
}