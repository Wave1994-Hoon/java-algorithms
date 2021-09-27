package medium._22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        process(n, 0, 0, "",result);     //recursive
        return result;
    }

    private static void process(int n, int openNumber, int closedNumber, String element, List<String> result) {
        // check terminate
        if (openNumber == n && closedNumber == n) {
            result.add(element);
            return;
        }

        // next recursive
        if (openNumber < n) {
            process(n, openNumber + 1, closedNumber, element + "(", result);
        }

        if (openNumber > closedNumber ) {
            process(n, openNumber, closedNumber + 1, element + ")", result);
        }

    }

}
