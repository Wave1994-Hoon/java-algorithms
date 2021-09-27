package easy._876_MiddleOfTheLinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    /*
    * 워커 러너 테크닉
    * walker: 한 번에 한 칸씩
    * runner: 한 번에 두 칸씩
    * runner가 끝나면 walker는 중간에 와있음 -> 중간지점 찾기 수월
    * 구현을 위한 브레인 스토밍
    * - 짝수
    * 1.
    * walker: 1x 2
    * runner: 1  2x
    * 2.
    * walker: 1 2x
    * runner: 1  2 nullx
    *
    * - 홀수
    * 1.
    * walker: 1x 2  3
    * runner: 1  2x 3
    * 2.
    * walker: 1 2x 3
    * runner: 1 2  3x --> 한 번 더 똘면 runner = null 이 떄 walker 리턴
    *
    * - 정리
    * runner 한 칸 전진, walker 한 칸 전진, runner 한 칸 전진
    * */
    public ListNode middleNode(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        while(runner != null) {
            runner = runner.next;
            if (runner != null) {
                walker = walker.next;
                runner = runner.next;
            }
        }
        return walker;
    }
}
