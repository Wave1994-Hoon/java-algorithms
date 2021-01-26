package easy._142_LinkedListCycle2;

/*
* 접근법
* walker: 한 번에 한 칸씩
* runner: 한 번에 두 칸씩
*
* ex) x x ㅁ x x x
*         x     x
*         x x x x
*
* A: 시작노드부터 루프의 처음 노드까지 거리
* B: 루프 전체의 길이
* X: 루프의 처음노트부터 현재 노드까지의 길이
*
* 만날 떄 까지의 간 거리
* walker: A + X
* runner: n*B + A + X
* 2walker = runner
* --> A + X = n*B
* --> walker와 runner가 만날 때 시작 노드부터 루프의 처음 노드까지 거리 + 루프의 처음노드부터 현재 노드까지의 길이 더 하면 루프 시작 점 위치
*
* */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        while(runner != null) {
            runner = runner.next;
            if(runner != null) {
                runner = runner.next;
                walker = walker.next;
                if(runner == walker) {
                    break;
                }
            }
            if(runner == null) {
                return null;
            }
        }

        ListNode check = head;
        while(check != walker) {
            check = check.next;
            walker = walker.next;
        }
        return check;
    }
}
