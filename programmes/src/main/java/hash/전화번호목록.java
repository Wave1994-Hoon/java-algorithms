package hash;

import java.util.HashSet;
import java.util.Set;

public class 전화번호목록 {
  public boolean solution(String[] phone_book) {
    boolean answer = true;

    Set<String> phoneBooks = new HashSet<>();

    for (String s : phone_book) {
      phoneBooks.add(s);
    }

    for (int i = 0; i < phone_book.length; i++) {
      String phoneNumber = phone_book[i];
      char[] numbers = phoneNumber.toCharArray();

      String temp = "";

      for (char number : numbers) {
        temp += number;

        if (!temp.equals(phoneNumber)) {
          if (phoneBooks.contains(temp)) {
            return false;
          }
        }
      }
    }
    return answer;
  }

}
