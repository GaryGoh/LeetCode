package google.LRUCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {

    int capacity;
    HashMap cache;
    LinkedList cacheQueue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheQueue = new LinkedList();
        this.cache = new HashMap();
    }

    public int get(int key) {
        ArrayList ar = new ArrayList<String>();
        if (cache.containsKey(key)) {
            cacheQueue.remove(new Integer(key));
            cacheQueue.add(key);
            return (int) cache.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cacheQueue.remove(new Integer(key));
            cacheQueue.add(key);
        } else {
            if (cache.size() >= capacity) {
                cache.remove(cacheQueue.poll());
            }
            if (!cacheQueue.contains(key)) {
                cacheQueue.add(key);
            }
        }
        cache.put(key, value);
    }

    public static void main (String[] args) {
        LRUhelper h = new LRUhelper();
        String res = h.readTestData("/IHR/LeetCodeNew/src/google/LRUCache/lru.txt");
        System.out.print(res);
    }
}

