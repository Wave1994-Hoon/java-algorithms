package 큐;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 큐뒤집기 {
    public static void main(String[] args) {
        Queue<Integer> inputQueue = new LinkedList<>();
        inputQueue.add(1);
        inputQueue.add(2);
        inputQueue.add(3);

        Queue<Integer> outputQueue = new LinkedList<>();
        outputQueue.add(3);
        outputQueue.add(2);
        outputQueue.add(1);

        assertThat(reverse(inputQueue)).isEqualTo(outputQueue);
    }

    private static Queue<Integer> solution(Queue<Integer> numbers) {
        Stack<Integer> stack = new Stack<>();

        while (!numbers.isEmpty()) {
            stack.push(numbers.poll());
        }

        while (!stack.isEmpty()) {
            numbers.offer(stack.pop());
        }
        return numbers;
    }

    private static Queue<Integer> reverse(Queue<Integer> numbers) {
        if (numbers.isEmpty()) {
            return numbers;
        }

        int front = numbers.poll();
        numbers = reverse(numbers);
        numbers.offer(front);

        return numbers;
    }
}
