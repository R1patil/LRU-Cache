package com.lld.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple generic LRU (Least Recently Used) Cache implementation.
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int maxItemsCount;

    public LRUCache(int maxItemsCount) {
        super(maxItemsCount, 0.75f, true);
        this.maxItemsCount = maxItemsCount;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        boolean shouldRemove = size() > maxItemsCount;
        if (shouldRemove) {
            System.out.println("Evicted key: " + eldest.getKey());
        }
        return shouldRemove;
    }
}
