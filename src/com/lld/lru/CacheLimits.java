package com.lld.lru;

/**
 * Defines cache configuration such as maximum item limit.
 */
public class CacheLimits {
    private final int maxItemsCount;

    public CacheLimits(int maxItemsCount) {
        this.maxItemsCount = maxItemsCount;
    }

    public int getMaxItemsCount() {
        return maxItemsCount;
    }
}
