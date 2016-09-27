package leetcode.hard;

import org.junit.Test;

/**
 * Created by PV029500 on 9/21/2016.
 */
public class LRUCacheTest {


    @Test
    public void testGet() throws Exception {
        LRUCache lruCache = new LRUCache(10);
//        lruCache.set(2, 1);
//        System.out.println(lruCache.get(2));
//        lruCache.set(3, 2);
//        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(3));

        lruCache.set(10,13);
        lruCache.set(3,17);
        lruCache.set(6,11);
        lruCache.set(10,5);
        lruCache.set(9,10);
        lruCache.get(13);
        lruCache.set(2,19);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.set(5,25);
        lruCache.get(8);
        lruCache.set(9,22);lruCache.set(5,5);lruCache.set(1,30);
        lruCache.get(11);
        lruCache.set(9,12);lruCache.get(7);lruCache.get(5);lruCache.get(8);lruCache.get(9);
        lruCache.set(4,30);
        lruCache.set(9,3);lruCache.get(9);lruCache.get(10);lruCache.get(10);lruCache.set(6,14);
        lruCache.set(3,1);
        lruCache.get(3);
        lruCache.set(10,11);
        lruCache.get(8);lruCache.set(2,14);lruCache.get(1);
        lruCache.get(5);
        lruCache.get(4);lruCache.set(11,4);lruCache.set(12,24);lruCache.set(5,18);lruCache.get(13);
        lruCache.set(7,23);lruCache.get(8);lruCache.get(12);lruCache.set(3,27);lruCache.set(2,12);lruCache.get(5);
        lruCache.set(2,9);
        lruCache.set(13,4);
        lruCache.set(8,18);lruCache.set(1,7);
        lruCache.get(6);lruCache.set(9,29);


        lruCache.set(8,21);lruCache.get(5);lruCache.set(6,30);lruCache.set(1,12);lruCache.get(10);lruCache.set(4,15);
        lruCache.set(7,22);lruCache.set(11,26);lruCache.set(8,17);lruCache.set(9,29);lruCache.get(5);lruCache.set(3,4);
        lruCache.set(11,30);lruCache.get(12);lruCache.set(4,29);lruCache.get(3);lruCache.get(9);lruCache.get(6);lruCache.set(3,4);
        lruCache.get(1);lruCache.get(10);lruCache.set(3,29);lruCache.set(10,28);lruCache.set(1,20);lruCache.set(11,13);
        lruCache.get(3);lruCache.set(3,12);lruCache.set(3,8);lruCache.set(10,9);lruCache.set(3,26);lruCache.get(8);
        lruCache.get(7);lruCache.get(5);lruCache.set(13,17);lruCache.set(2,27);lruCache.set(11,15);lruCache.get(12);
        lruCache.set(9,19);lruCache.set(2,15);lruCache.set(3,16);lruCache.get(1);lruCache.set(12,17);lruCache.set(9,1);lruCache.set(6,19);lruCache.get(4);lruCache.get(5);
        lruCache.get(5);lruCache.set(8,1);lruCache.set(11,7);lruCache.set(5,2);lruCache.set(9,28);lruCache.get(1);lruCache.set(2,2);
        lruCache.set(7,4);lruCache.set(4,22);lruCache.set(7,24);lruCache.set(9,26);lruCache.set(13,28);lruCache.set(11,26);

    }
}