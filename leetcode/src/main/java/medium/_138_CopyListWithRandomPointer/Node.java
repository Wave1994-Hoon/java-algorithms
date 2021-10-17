package medium._138_CopyListWithRandomPointer;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int value) {
        this.val = value;
        this.next = null;
        this.random = null;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setRandom(Node random) {
        this.random = random;
    }
}
