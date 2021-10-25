package org.example;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter implements Runnable {
    private ConcurrentLinkedQueue<Client> queue;
    private final int clientDB;
    private final int delay;

    public CallCenter() {
        this.queue = new ConcurrentLinkedQueue<>();
        this.clientDB = Client.DB_SIZE;
        this.delay = Client.DELAY;
    }

    public void meetClient() {
        if(!queue.isEmpty()) {
            queue.remove();
            System.out.println("Клиенту ответили. Очередь ожидания : " + getQueueSize() + " клиент(ов).");
        }
    }

    public int getQueueSize() {
        return queue.size();
    }

    @Override
    public void run() {
        System.out.println("Рабочий день начался :)");

        for (int i = 0; i < clientDB; i++) {

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            queue.add(new Client());
            System.out.println("У нас новый клиент! Очередь ожидания : " + getQueueSize() + " клиент(ов).");
        }
    }
}
