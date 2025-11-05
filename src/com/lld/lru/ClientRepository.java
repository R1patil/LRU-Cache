package com.lld.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Simulates a database + caching layer using LRUCache.
 */
public class ClientRepository {

    // Simulated "slow" database (in-memory)
    private final Map<String, Client> database = new HashMap<>();

    // LRU cache for faster access
    private final LRUCache<String, Client> cache;

    public ClientRepository(CacheLimits cacheLimits) {
        this.cache = LRUCacheProvider.createLRUCache(cacheLimits);
    }

    /** Adds or updates a client. */
    public void save(Client client) {
        System.out.println("Saving client in database: " + client);
        database.put(client.getId(), client);

        cache.put(client.getId(), client);
        System.out.println("Updated cache: " + cache);
    }

    /** Gets a client by ID, preferring cache first. */
    public Client findById(String id) {
        if (cache.containsKey(id)) {
            System.out.println("Cache hit for ID: " + id);
            return cache.get(id);
        }
        System.out.println("Cache miss for ID: " + id + " → fetching from DB...");
        Client client = database.get(id);
        if (client != null) {
            cache.put(id, client);
        }
        return client;
    }

    /** Deletes a client. */
    public void delete(String id) {
        System.out.println("Deleting client with ID: " + id);
        database.remove(id);
        cache.remove(id);
    }

    /** Returns all clients from the database. */
    public Map<String, Client> findAll() {
        return new HashMap<>(database);
    }

    @Override
    public String toString() {
        return "DB=" + database + ", Cache=" + cache;
    }
}
