package practice;

public class 문자열을_정수로_바꾸기 {

    public int solution1(String s) {
        int number = Integer.parseInt(s);
        return number;
    }

    public int solution2(String s) {
        boolean sig = true;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                sig = false;
                continue;
            }

            if (s.charAt(i) == '+') {
                continue;
            }

            char ch = s.charAt(i);
            result = result * 10 + (ch - '0');

        }

        if (sig == true) {
            return result;
        }

        return result * -1;
    }

}
