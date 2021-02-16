package easy._20_ValidParenthese;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char character : array) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            }

            if (character == ')') {
                if (stack.size() == 0 || stack.pop() != '(') {
                    return false;
                }
            }

            if (character == ']') {
                if (stack.size() == 0 || stack.pop() != '[') {
                    return false;
                }
            }

            if (character == '}') {
                if (stack.size() == 0 || stack.pop() != '{') {
                    return false;
                }
            }
        }

        if (stack.size() != 0) {
            return false;
        }

        return true;
    }
}

