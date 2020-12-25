package 배열;

import static org.assertj.core.api.Assertions.assertThat;

/*
* 문제 설명
* - 문자열 뒤집기
* - 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
*/

public class 문자열_뒤집기 {
    public static void main(String[] args) {
        assertThat(mySolution("Hello".toCharArray())).isEqualTo("olleH".toCharArray());
        assertThat(mySolution("happy new year".toCharArray())).isEqualTo("raey wen yppah".toCharArray());

        assertThat(bestSolution1("Hello".toCharArray())).isEqualTo("olleH".toCharArray());
        assertThat(bestSolution1("happy new year".toCharArray())).isEqualTo("raey wen yppah".toCharArray());

        assertThat(bestSolution2("Hello".toCharArray())).isEqualTo("olleH".toCharArray());
        assertThat(bestSolution2("happy new year".toCharArray())).isEqualTo("raey wen yppah".toCharArray());

        assertThat(bestSolution3("Hello".toCharArray())).isEqualTo("olleH".toCharArray());
        assertThat(bestSolution3("happy new year".toCharArray())).isEqualTo("raey wen yppah".toCharArray());
    }

    private static char[] mySolution(char[] chars) {
        int end = chars.length - 1;

        for (int start = 0; start <= end; start++) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;

            end -= 1;

            if (start + 1 == end) {
                break;
            }
        }
        return chars;
    }


    /*
     * 시간복잡도: O(n)
     * 공간복잡도: O(n)
     */
    private static char[] bestSolution1(char[] message) {
        int length = message.length;
        char[] reversedMessage = new char[length];

        for (int i = length - 1; i >= 0; i--) {
            reversedMessage[length - 1 - i] = message[i];
        }
        return reversedMessage;
    }

    /*
     * Swap 사용
     * 시간복잡도: O(n/2)
     * 공간복잡도: O(1)
     */
    private static char[] bestSolution2(char[] message) {
        int length = message.length;

        for (int i = 0; i < length / 2; i++) {
            char temp = message[i];
            message[i] = message[length - 1 - i];
            message[length - 1 - i] = temp;
        }
        return message;
    }

    /*
     * String Builder 사용 -> Swap
     */
    private static char[] bestSolution3(char[] message) {
        StringBuilder sb = new StringBuilder(String.valueOf(message));
        int length = sb.length();

        for (int i = 0; i < length / 2; i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(length - 1 - i));
            sb.setCharAt(length - 1 - i, temp);
        }

        return sb.toString().toCharArray();
    }
}
