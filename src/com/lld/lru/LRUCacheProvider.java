package com.lld.lru;

/**
 * Factory class for creating LRUCache instances based on CacheLimits.
 */
public class LRUCacheProvider {

    private LRUCacheProvider() {
        // Prevent instantiation
    }

    public static <K, V> LRUCache<K, V> createLRUCache(CacheLimits limits) {
        return new LRUCache<>(limits.getMaxItemsCount());
    }
}
