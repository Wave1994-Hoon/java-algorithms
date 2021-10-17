package easy._155_MinStack;

import java.util.Stack;

public class MinStack {
    /* min 값을 가지고 있는 노드 생성 */
    class Node{
        int value;
        int min;
        Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    Stack<Node> stack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        Node node = null;
        if(stack.isEmpty()) {
            node = new Node(x,x);
        }

        if(!stack.isEmpty()) {
            int min = stack.peek().min;
            if (min >= x) {
                node = new Node(x, x);
            }
            if(min < x) {
                node = new Node(x, min);
            }
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
