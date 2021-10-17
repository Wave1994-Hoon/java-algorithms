package easy._21_MergeTwoSortedLists;

public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode current = null;


        // result   : null  ->  1  ->
        // current  : null  ->  1  ->  1
        // list 1   : 1     ->  2  ->  2
        // list 2   : 1     ->  1  ->  3


        while (list1 != null || list2 != null) {
            if (list2 == null || (list1 != null && list1.val < list2.val )) {
                // pick from List 1
                if (result == null) {
                    result  = list1;
                    current = list1;
                    list1 = list1.next;

                    continue;
                }

                current.next = list1;
                current = list1;
                list1 = list1.next;

                continue;
            }

            // pick from List 2
            if (result == null) {
                result  = list2;
                current = list2;
                list2 = list2.next;

                continue;
            }

            current.next = list2;
            current = list2;
            list2 = list2.next;

        }

        return result;
    }
}
