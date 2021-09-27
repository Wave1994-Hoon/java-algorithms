package easy._141_LinkedListCycle;

import java.util.List;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
* walker: 한 번에 한 칸씩
* runner: 한 번에 두 칸씩 전진
*
* 싸이클이 있으면 둘은 언젠가 만남
* 싸이클이 없으면 러너거 먼저 null에 닿음
* 시간 복잡도: O(n)
* 공간 복잡도: O(1)
* */
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        while(runner != null) {
            runner = runner.next;
            if(runner == null) {
                break;
            }

            if(runner != null) {
                runner = runner.next;
                walker = walker.next;

                if(runner == walker) {
                    break;
                }
            }
        }

        if(runner == null) {
            return false;
        }
        return true;
    }
}
