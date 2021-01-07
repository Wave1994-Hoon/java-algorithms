package 큐;

import java.util.LinkedHashSet;
import java.util.Set;

/*
* 순서 보장 , hash set 순서 x
*/
public class LRUCacheWithLinkedHashSet {
    public static void main(String[] args) {

    }

    private int cacheSize;

    private Set<Integer> cache;

    public LRUCacheWithLinkedHashSet(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cache = new LinkedHashSet<>();
    }

    private void query(int number) {
        if (!cache.contains(number)) {
            if (cache.size() == cacheSize) {
                Integer firstOne = cache.iterator().next();  // O(1) ??
                cache.remove(firstOne);
            }

            cache.add(number);
        } else {
            cache.remove(number);
            cache.add(number);
        }
    }
}
