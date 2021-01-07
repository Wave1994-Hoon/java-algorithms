package 큐;

import java.util.Deque;
import java.util.LinkedList;

public class LRUCacheWithDeque {
    public static void main(String[] args) {
        LRUCacheWithDeque lruCacheWithDeque = new LRUCacheWithDeque(3);
    }
    private int cacheSize;

    private Deque<Integer> cache;

    public LRUCacheWithDeque(int cacheSize) {
        this.cacheSize = cacheSize;
        cache = new LinkedList<>();
    }

    private void print() {
        System.out.println(cache);
    }

    /*
    * O(n)의 시간복잡도함
    *
    * contains
    * 중복 값이 없는 리스트이기 때문에 contains 오퍼레이션은 해쉬 맵으로 더 효율적으로 풀 수 있음
    *
    * remove
    * 링크드 리스트: 자바에서는 노드에 대한 정보를 private하게 가지고 있음, 접근 불가능 / 직접 구현해야함
    * 양쪽에서 넣고 빼려면 더블 링크드 리스트로 구현해야
    */
    private void query(int number) {
        if (cache.contains(number)) {  // O(n)
            cache.remove(number); // O(n)
            cache.addFirst(number); // O(1)
        } else {
            if (cache.size() == cacheSize) {
                cache.removeLast(); // O(1)
            }
            cache.addFirst(number);  // O(1)
        }
    }
}

