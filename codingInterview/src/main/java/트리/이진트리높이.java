package 트리;

public class 이진트리높이 {

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

        System.out.println(searchHight(root));
    }

    public static int searchHight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = searchHight(root.left);
        int rightDepth = searchHight(root.right);
        System.out.println("leftDepth = " + leftDepth );
        System.out.println("rightDepth = " + rightDepth);

        if (leftDepth > rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }
}
