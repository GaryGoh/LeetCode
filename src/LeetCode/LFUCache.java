package LeetCode;

import org.junit.Assert;

import java.util.*;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * /**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LFUCache {
    Map<Integer, int[]> map;
    int minEleKey;
    int capacity;

    public LFUCache(int capacity) {
        map = new HashMap<Integer, int[]>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        return -1;
    }

    public void put(int key, int value) {
        if (map.size() < capacity) {
            // put element
            if (map.containsKey(key)) {
                int count = map.get(key)[1];
                map.put(key, new int[] {value, count + 1});
            } else {
                map.put(key, new int[] {value, 1});
            }

            // update minEleKey
            if (map.get(minEleKey)[1] >= map.get(key)[1]) {
                minEleKey = key;
            }
        } else {
            map.remove(minEleKey);
            map.put(key, new int[] {value, 1});
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        //LFU
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));
        cache.put(3, 3);
        Assert.assertEquals(-1, cache.get(2));
        Assert.assertEquals(3, cache.get(3));

        cache.put(4, 4);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(3, cache.get(3));
        Assert.assertEquals(4, cache.get(4));



//        cache.put(2, 1);
//        cache.put(1, 1);
//        cache.put(2, 3);
//        cache.put(4, 1);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
    }
}
