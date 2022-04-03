package org.example;

public class Manager implements Runnable {
    public static final int DELAY = 3_500;
    public static final int MANAGERS_DEPT_SIZE = 3;
    private ClientQueue queue;

    public Manager(ClientQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Менеджер приступил к работе.");

        while (queue.releaseClientFromQueue() != null) {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Клиент остался доволен. Ожидают ответа : " + queue.getClientQueueSize() + ".");
        }
    }
}
