package medium._138_CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.value);
        RandomListNode current = newHead;
        map.put(head, newHead);

        while (head != null) {
            if (head.next != null) {
                if (!map.containsKey(head.next)) {
                    map.put(head.next, new RandomListNode(head.next.value));
                }
                current.next = map.get(head.next);
            }

            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.value));
                }
                current.next = map.get(head.random);
            }

            head = head.next;
            current = current.next;
        }
        return newHead;
    }
}
