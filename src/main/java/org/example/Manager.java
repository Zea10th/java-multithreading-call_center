package org.example;

public class Manager implements Runnable {
    public static final int DELAY = 3_500;
    public static final int MANAGERS_DEPT_SIZE = 3;
    private CallCenter callCenter;

    public Manager(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        System.out.println("Менеджер приступил к работе.");

        while (true) {
            callCenter.meetClient();

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Клиент остался доволен.");

            if (callCenter.getQueueSize() == 0) break;
        }
    }
}
