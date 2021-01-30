package 트리;

import 큐.바이너리트리_최대합;

/*
* 후위 탐색
*       1
*    2      3
* 4    5   6   7
*
*
* 문제 예시
* Left -> right -> root
* 4 -> 5 -> 2 -> 6 -> 7 -> 3 -> 1
* */
public class 후위탐색 {

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) { this.value = value; }
    }

    public static void main(String[] args) throws Exception {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        후위탐색 result = new 후위탐색();
        result.preOrder(root,4);
    }

    private int count = 0;

    private void preOrder(Node root, int index) {
        if (root != null) {
            preOrder(root.left, index);
            preOrder(root.right, index);
            if (count ++ == index) {
                System.out.println(root.value);
            }
        }
    }
}
