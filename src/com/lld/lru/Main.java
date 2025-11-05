package com.lld.lru;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Starting Client Repository Demo...");

        CacheLimits cacheLimits = new CacheLimits(2);
        ClientRepository repo = new ClientRepository(cacheLimits);

        // Add clients
        repo.save(new Client("1", "Alice"));
        repo.save(new Client("2", "Bob"));
        repo.save(new Client("3", "Charlie")); // Evicts least recently used

        System.out.println("\n🔍 Fetching clients:");
        System.out.println("Find 1 → " + repo.findById("1")); // may be evicted
        System.out.println("Find 2 → " + repo.findById("2"));
        System.out.println("Find 3 → " + repo.findById("3"));

        // Update a client
        Client updated = new Client("2", "Bobby");
        repo.save(updated);

        // Re-access to update cache order
        repo.findById("2");
        repo.findById("3");

        // Add one more to trigger eviction
        repo.save(new Client("4", "Daisy"));

        System.out.println("\n✅ Final repository state:");
        System.out.println(repo);
    }
}
