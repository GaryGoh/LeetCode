package UnitTest.LRUCache;

import google.LRUCache.LRUCache;
import org.junit.Test;

/**
 * Created by mgao on 2018/2/26.
 */
public class LRUTest {


    @Test
    public void test1(){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
//        assertEquals(2, cache.(haystack, needle));
    }
}
