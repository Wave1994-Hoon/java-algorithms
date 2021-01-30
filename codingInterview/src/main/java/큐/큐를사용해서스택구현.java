package 큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class 큐를사용해서스택구현 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        QueueStack queueStack = new QueueStack();
        queueStack.push(1);
        queueStack.push(2);
        queueStack.push(3);

        assertThat(queueStack.pop()).isEqualTo(stack.pop());
    }

    public static class QueueStack {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();  // tmp

        private Integer pop() {
            if (queue1.isEmpty()) { return null; }
            return queue1.poll();
        }

        private void push(int number) {
            queue2.offer(number);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
    }
}
