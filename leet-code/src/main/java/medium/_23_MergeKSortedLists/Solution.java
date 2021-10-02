package medium._23_MergeKSortedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        // Input: lists = [[1,4,5],[1,3,4],[2,6]]
        // Output: [1,1,2,3,4,4,5,6]
        ListNode listNode1 = new ListNode();
        listNode1.setVal(5);
        listNode1.setNext(null);

        ListNode listNode2 = new ListNode();
        listNode2.setVal(4);
        listNode2.setNext(listNode1);

        ListNode listNodeA = new ListNode();
        listNodeA.setVal(1);
        listNodeA.setNext(listNode2);


        ListNode listNode3 = new ListNode();
        listNode3.setVal(4);
        listNode3.setNext(null);

        ListNode listNode4 = new ListNode();
        listNode4.setVal(3);
        listNode4.setNext(listNode3);

        ListNode listNodeB = new ListNode();
        listNodeB.setVal(1);
        listNodeB.setNext(listNode4);


        ListNode listNode6 = new ListNode();
        listNode6.setVal(6);
        listNode6.setNext(null);

        ListNode listNodeC = new ListNode();
        listNodeC.setVal(2);
        listNodeC.setNext(listNode6);

        ListNode[] lists = {listNodeA, listNodeB, listNodeC};

        ListNode listNode = mergeKLists(lists);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
        System.out.println(listNode.next.next.next.val);
        System.out.println(listNode.next.next.next.next.val);

    }


    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode result = null;
        ListNode current = null;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                lists.length,
                Comparator.comparingInt(a -> a.val)
        );

        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            priorityQueue.offer(node);
        }

        System.out.println(priorityQueue);

        while (hasNotNode(priorityQueue)) {
            ListNode node = priorityQueue.poll();
            if (node.next != null) {
                priorityQueue.offer(node.next);
            }

            // init
            if (result == null) {
                result = node;
                current = node;
                continue;
            }

            current.next = node;
            current = node;

        }

        return result;
    }

    private static boolean hasNotNode(PriorityQueue<ListNode> priorityQueue) {
        return !priorityQueue.isEmpty();
    }
}
