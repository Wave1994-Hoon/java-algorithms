package easy._232_ImplementQueueUsingStacks;

import java.util.Stack;

public class MyQueue {

    /*
    * 스택: LIFO + LIFO = FIFO
    * 들어왔던 걸 뒤집으면 됨
    * */

    /* 인에서 들어가서 아웃으로 나온다. */
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        peek();
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}


