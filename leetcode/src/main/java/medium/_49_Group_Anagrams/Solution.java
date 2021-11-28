package medium._49_Group_Anagrams;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  private Map<String, List<String>> map = new HashMap<>();

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    List<String> input = Arrays.stream(strs)
        .collect(Collectors.toList());

    input.forEach(string -> {
      char[] chars = string.toCharArray();
      Arrays.sort(chars);
      String sortedString = new String(chars);

      if (map.containsKey(sortedString)) {
        List<String> innerList = map.get(sortedString);
        innerList.add(string);
        map.put(sortedString, innerList);
        return;
      }

      List<String> innerList = new ArrayList<>();
      innerList.add(string);
      map.put(sortedString, innerList);
    });

    map.keySet().forEach(key -> {
      result.add(map.get(key));
    });

    return result;
  }
}
