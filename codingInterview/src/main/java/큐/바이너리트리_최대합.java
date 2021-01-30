package 큐;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
* 넓이 우선 탐색(BFS)
* - 계층 순서대로 탐색
*
*        1
*     2      3
*   4   5  6   7
* ====================================
*  ==>  ?  / 7  6 / 5  4  / 3  2  ==>
* ====================================
*
* */
public class 바이너리트리_최대합 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        assertThat(maxSum(root)).isEqualTo(15);

    }

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) { this.value = value; }
    }

    /*
    * 시간 복잡도: O(n)
    * 공간 복잡도: O(B) ?? ---> 트리 최대 넓이
    * */
    private static int maxSum(Node root) {
        if (root == null) { return 0; }

        int result = root.value;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            int sum = 0;

            while (count > 0) {
                count--;
                Node node = queue.poll();
                sum += node.value;
                if (node.left != null) { queue.offer(node.left); }
                if (node.right != null) { queue.offer(node.right); }
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}
