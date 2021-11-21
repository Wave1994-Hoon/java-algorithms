package medium._131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {
//  public static void main(String[] args) {
//    Solution solution = new Solution();
//    solution.partition("aab");
//  }

  public List<List<String>> partition(String input) {
    List<List<String>> result = new ArrayList<>();
    dfs(0, result, new ArrayList<>(), input);
    return result;
  }

  private void dfs(int start, List<List<String>> result, List<String> currentList, String input) {
    // input 사이즈 만큼 탐색을 하면 종료한다.
    if (start >= input.length()) {
      result.add(new ArrayList<>(currentList));
      return;
    }

    /**
     * input 의 subString 을 탐색한다.
     * start = 0, end = 0 --> start = 0, end = 1 --> start = 0, end = 2
     * start = 1, end = 1 --> ...
     *
     * currentList: [a],        start: 0, ent: 0
     * currentList: [a, a],     start: 1, ent: 1
     * currentList: [a, a, b],  start: 2, ent: 2
     * currentList: [aa],       start: 0, ent: 1
     * currentList: [aa, b],    start: 2, ent: 2
     */
    for (int end = start; end < input.length(); end++) {
      if (isPalindrome(input, start, end)) {
        currentList.add(input.substring(start, end + 1));  // subString 을 currentList 에 넣는다.
        dfs(end + 1, result, currentList, input);    // backtrack and remove the current substring from currentList
        currentList.remove(currentList.size() - 1); // 조건에 만족하는 currentList 를 result 에 넣었기 때문에 비워준다.
      }
    }
  }

  // 회문(palindrome) 인지 검증한다.
  private boolean isPalindrome(String input, int start, int end) {
    while (start < end) {
      if (input.charAt(start++) != input.charAt(end--)) {
        // 조건에 만족하지 않으니 start +1, end  - 1 한다.
        return false;
      }
    }
    return true;
  }
}
