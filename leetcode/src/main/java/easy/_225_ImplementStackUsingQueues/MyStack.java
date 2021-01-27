package easy._225_ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    /*
    * 큐: FIFO
    * 스택: LIFO
    * 마지막으로 들어온 원소가 가장 아래에 있으면 된다.
    * */
    Queue<Integer> queue = new LinkedList<>();


    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
             queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
