package org.example;

public class CallCenter implements Runnable {
    private ClientQueue queue;
    private final int clientDB;
    private final int delay;

    public CallCenter(ClientQueue queue) {
        this.queue = queue;
        this.clientDB = Client.DB_SIZE;
        this.delay = Client.DELAY;
    }

    @Override
    public void run() {
        System.out.println("Рабочий день начался :)");

        for (int i = 0; i < clientDB; i++) {

            try {
                Thread.sleep(delay);
                queue.putClientInQueue();
                System.out.println("У нас новый клиент! Очередь ожидания : " + queue.getClientQueueSize() + " клиент(ов).");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
