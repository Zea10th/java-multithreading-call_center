package org.example;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ClientQueue {
    private static ClientQueue instance;
    private ConcurrentLinkedQueue<Client> queue;

    private ClientQueue() {
        queue = new ConcurrentLinkedQueue<>();
    }

    public void putClientInQueue() {
        queue.add(new Client());
    }

    public Client releaseClientFromQueue() {
        return queue.poll();
    }

    public int getClientQueueSize() {
        return queue.size();
    }

    public static ClientQueue getInstance() {
        if (instance == null) {
            instance = new ClientQueue();
        }
        return instance;
    }
}
