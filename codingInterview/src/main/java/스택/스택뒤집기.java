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

    private static Stack<Integer> mySolution(Stack<Integer> numbers) {
        Stack<Integer> reversedStack = new Stack<>();

        while (!numbers.isEmpty()) {
            reversedStack.push(numbers.pop());
        };

        return reversedStack;
    }

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
