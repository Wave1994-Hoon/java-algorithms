package medium._138_CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val); // new Head 한 노드 참조
        Node current = newHead;              // newHead 와 current 는 같은 메모리를 참조
        map.put(head, newHead);              // Hash Map 에 기존 head 와 새로 생성한 new Head 삽입

        int count = 0;
        while (head != null) {
            if (head.next != null) {
                if (hasNotKey(map, head.next)) {
                    map.put(head.next, new Node(head.next.val));
                }
                current.next = map.get(head.next);
            }

            if (head.random != null) {
                if (hasNotKey(map, head.random)) {
                    map.put(head.random, new Node(head.random.val));
                }
                current.random = map.get(head.random);
            }

            head = head.next; // original 링크드 리스트르 하나씩 밀어준다.
            current = current.next;
            System.out.println("========================");
            if (count == 0) {
                System.out.println("head: " + newHead.val);
                System.out.println("head: " + newHead.next.val);
            }

            if (count == 1) {
                System.out.println("head: " + newHead.val);
                System.out.println("head: " + newHead.next.val);
                System.out.println("head: " + newHead.next.next.val);
            }

            if (count == 2) {
                System.out.println("head: " + newHead.val);
                System.out.println("head: " + newHead.next.val);
                System.out.println("head: " + newHead.next.next.val);
                System.out.println("head: " + newHead.next.next.next.val);
            }
            if (count == 3) {
                System.out.println("head: " + newHead.val);
                System.out.println("head: " + newHead.next.val);
                System.out.println("head: " + newHead.next.next.val);
                System.out.println("head: " + newHead.next.next.next.val);
                System.out.println("head: " + newHead.next.next.next.next.val);
            }
            System.out.println("========================");

            count += 1;
        }
        return newHead;
    }

    private boolean hasNotKey(Map<Node, Node> map, Node random) {
        return !map.containsKey(random);
    }
}
