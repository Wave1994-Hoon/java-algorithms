package 스택;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * 문제 설명
 * - 스택 뒤집기
 *
 * 조건
 * 다른 데이터 구조를 사용해도 되는지 ?
 */
public class 스택뒤집기 {

    public static void main(String[] args) {
        Stack<Integer> inputStack = new Stack<>();
        inputStack.push(1);
        inputStack.push(2);
        inputStack.push(3);

        Stack<Integer> outputStack = new Stack<>();
        outputStack.push(3);
        outputStack.push(2);
        outputStack.push(1);

        assertThat(mySolution(inputStack)).isEqualTo(outputStack);
        assertThat(bestSolution(inputStack)).isEqualTo(outputStack);

    }

    /*
    * 스택을 사용한 풀이
    * 시간복잡도: O(n)
    * 공간복잡도: O(n)
    */
    private static Stack<Integer> mySolution(Stack<Integer> numbers) {
        Stack<Integer> reversedStack = new Stack<>();

        while (!numbers.isEmpty()) {
            reversedStack.push(numbers.pop());
        };

        return reversedStack;
    }

    /*
    * 재귀를 이용한 풀이
    * 위에 풀이 보다 성능은 낮지만, 재귀적으로도 풀 수 있는 사고력이 필요함
    * 시간 복잡도: O(n^2) -> 중첩된 재귀 함수
    * 공간 복잡되: O(n)
    */
    private static Stack<Integer> bestSolution(Stack<Integer> numbers) {
        if (numbers.isEmpty()) {
            return numbers;
        }
        int temp = numbers.pop();

        bestSolution(numbers);
        insertAtBottom(numbers, temp);

        return numbers;
    }

    private static Stack<Integer> insertAtBottom(Stack<Integer> numbers, int number) {
        if (numbers.isEmpty()) {
            numbers.push(number);
            return numbers;
        }
        int temp = numbers.pop();
        insertAtBottom(numbers, number);
        numbers.push(temp);
        System.out.println(numbers);
        return numbers;
    }
}
