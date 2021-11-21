package medium._146._LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  // O(1) 구현 조건이 있기 떄문에 포인터 사용
  // Example: (4,6) - (2,2) - (3,3)
  //          head             tail
  public static class CacheItem {
    int key;
    int value;
    CacheItem prev;
    CacheItem next;

    public CacheItem(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  CacheItem head;
  CacheItem tail;
  int capacity;
  Map<Integer, CacheItem> map;

  public LRUCache(int capacity) {
    head = null;
    tail = null;
    map = new HashMap<>();
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      CacheItem currentCacheItem = map.get(key);
      movePointer(currentCacheItem);
      return currentCacheItem.value;
    }

    return -1;
  }

  public void put(int key, int value) {
    if (get(key) == -1) {
      insertValueToHead(key, value);
      return;
    }
    updateValue(key, value);
  }

  private void movePointer(CacheItem currentCacheItem) {
    if (currentCacheItem != head) {
      if (currentCacheItem == tail) {
        // TODO: move tail to one in front
        tail = tail.prev;  // size 가 2 이상이기 때문에 null x
      }

      /**
       * TODO: move currentCacheItem to head
       // AS-IS: head, ..., current.prev, current, current.next
       // TO-BE: current-head, ..., current.prev, current.next
       */
      if (currentCacheItem.prev != null) {
        currentCacheItem.prev.next = currentCacheItem.next;
      }

      if (currentCacheItem.next != null) {
        currentCacheItem.next.prev = currentCacheItem.prev;
      }

      currentCacheItem.next = head;
      head.prev = currentCacheItem;

      currentCacheItem.prev = null; // head 이기 때문에
      head = currentCacheItem;      // head 로 설정
    }
  }

  private void updateValue(int key, int value) {
    map.get(key).value = value;
  }

  private void insertValueToHead(int key, int value) {
    CacheItem currentCacheItem = new CacheItem(key, value);

    if (head == null) {
      head = currentCacheItem;
      tail = currentCacheItem;
    } else {
      // AS-IS: head ...
      // TO-BE: current - head ...
      currentCacheItem.next = head;
      head.prev = currentCacheItem;
      head = currentCacheItem;
    }

    map.put(key, currentCacheItem);

    if (map.size() > capacity) {
      evictTail();
    }

  }

  private void evictTail() {
     // AS-IS: ... tail.prev, tail
     // TO-BE: ... tail.prev
    map.remove(tail.key);

    tail.prev.next = null;  // size 가 2 이상이기 떄문에 null x
    tail = tail.prev;
  }
}
