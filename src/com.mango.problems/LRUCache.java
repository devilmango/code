package com.mango.problems;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LeetCode: 146. LRU Cache
 */
public class LRUCache {
    private int totalCacheCapacity;
    private int currentCacheCapacity;
    private Deque<CacheElement> cacheWindow;
    private Map<Integer, CacheElement> cacheElementReferenceMap;

    public LRUCache() {};

    private LRUCache(int capacity) {
        this.totalCacheCapacity = capacity;
        this.currentCacheCapacity = 0;
        this.cacheWindow = new LinkedList<>();
        this.cacheElementReferenceMap = new HashMap<>();
    }

    private int get(int key) {
        if(!cacheElementReferenceMap.containsKey(key)) {
            return -1;
        }
        CacheElement cacheElement = cacheElementReferenceMap.get(key);
        this.cacheWindow.remove(cacheElement);
        this.cacheWindow.addFirst(cacheElement);
        return cacheElement.value;
    }

    private void put(int key, int value) {
        if (!cacheElementReferenceMap.containsKey(key)) {
            if (currentCacheCapacity == totalCacheCapacity) {
                CacheElement lastCacheElement = cacheWindow.pollLast();
                cacheElementReferenceMap.remove(lastCacheElement.key);
                currentCacheCapacity--;
            }

            CacheElement cacheElement = new CacheElement(key, value);
            cacheWindow.addLast(cacheElement);
            currentCacheCapacity++;
            cacheElementReferenceMap.put(key, cacheElement);
        }
    }

    class CacheElement {
        public int key;
        public int value;

        CacheElement(int key, int value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return "[Key: "+key+", Value: "+value+"]";
        }

    }

    public void testLRUCache () {
        sampleTest();
    }
    public static final String GET = "Get: [%s]";
    public static final String PUT = "Put: current cache: %s";

    private void sampleTest() {
        int capacity = 3;
        LRUCache lruCache = new LRUCache(capacity);
        System.out.println(String.format(PUT, lruCache.cacheWindow));
        System.out.println(String.format(GET, lruCache.get(3)));
        lruCache.put(1, 11);
        System.out.println(String.format(PUT, lruCache.cacheWindow));
        lruCache.put(2, 22);
        System.out.println(String.format(PUT, lruCache.cacheWindow));
        lruCache.put(3, 33);
        System.out.println(String.format(PUT, lruCache.cacheWindow));
        System.out.println(String.format(GET, lruCache.get(2)));
        lruCache.put(4, 44);
        System.out.println(String.format(PUT, lruCache.cacheWindow));
        System.out.println(String.format(GET, lruCache.get(3)));
        System.out.println("------------------------------------------");
    }
}
