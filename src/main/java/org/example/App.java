package org.example;

import static org.example.Manager.MANAGERS_DEPT_SIZE;

public class App {
    public static final int DELAY = 0_500;

    public static void main(String[] args) throws InterruptedException {
        CallCenter callCenter = new CallCenter();
        Thread techSupport = new Thread(callCenter);
        techSupport.start();

        Thread[] managers = new Thread[MANAGERS_DEPT_SIZE];
        for (int i = 0; i < MANAGERS_DEPT_SIZE; i++) {
            managers[i] = new Thread(new Manager(callCenter));
            managers[i].start();
            Thread.sleep(DELAY);
        }

        while (techSupport.isAlive()
                || managers[0].isAlive()
                || managers[1].isAlive()
                || managers[2].isAlive()) {
            Thread.sleep(DELAY);
        }
        System.out.println("Команда техподдержки сегодня хорошо поработала.");
    }
}
