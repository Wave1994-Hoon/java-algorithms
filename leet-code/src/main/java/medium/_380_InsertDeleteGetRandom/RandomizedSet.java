package medium._380_InsertDeleteGetRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    /* key: element, value: index in the list */
    Map<Integer, Integer> map;
    ArrayList<Integer> arrayList;
    /* # of valid element in the list */
    int size;
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        arrayList = new ArrayList<>();
        size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,size++);
        arrayList.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int targetIndex = map.get(val);
        map.remove(val);
        if(targetIndex != size - 1) {
            int swap = arrayList.get(size -1);
            arrayList.set(targetIndex, swap);
            map.put(swap,targetIndex);
        }
        arrayList.remove(size-1);
        size--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int targetIndex = random.nextInt(size);
        return arrayList.get(targetIndex);
    }
}
