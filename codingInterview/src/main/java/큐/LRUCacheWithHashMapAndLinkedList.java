package 큐;


import java.util.HashMap;

public class LRUCacheWithHashMapAndLinkedList {
    public static void main(String[] args) {

    }

    private int cacheSize;

    private HashMap<Integer, Node> map;

    private Node head, tail;

    public LRUCacheWithHashMapAndLinkedList(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();
    }

    class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;
    }

    private void query(int number) {
        if (map.containsKey(number)) {
            Node node = map.get(number);
            remove(node);
            addToHead(node);
        } else {
            Node nodeToAdd = new Node();
            nodeToAdd.value = number;

            if (map.size() == this.cacheSize) {
                map.remove(tail.value);
                remove(tail);
            }
            addToHead(nodeToAdd);
            map.put(number, nodeToAdd);
        }
    }

    /*
    *
    *       p          n       n        n
    * null <--   A   -->   B   -->   C  --> null
    *         [Head] <--       <-- [Tail]
    *                 p         p
    */
    private void remove(Node node) {
        /* 맨 앞이 아님 */
        if (node.prev != null) {
            /* 대상 노드를 제외하고 앞 뒤로 연결 */
            node.prev.next = node.next;
        } else {
            /* 맨 앞임, 그 뒤 노드에 Head 위치 지정 */
            head = node.next;
        }

        /* 맨 뒤 아님 */
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addToHead(Node node) {
        /* 현재 head 인 노드를 가리켜야함 */
        node.next = head;
        node.prev = null;

        if (head != null) {
            /* 현재 head의 prev는 삽입되는 노드의 node를 가리킴 */
            head.prev = node;
        }

        /* Head 교체 */
        head = node;

        /* head 교체 후 taiㅣ이 없다면 */
        if (tail == null) {
            tail = head;
        }
    }
}
