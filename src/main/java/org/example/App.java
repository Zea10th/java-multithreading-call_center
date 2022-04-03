package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.example.Manager.MANAGERS_DEPT_SIZE;

public class App {
    public static final int DELAY = 0_500;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(MANAGERS_DEPT_SIZE);

        ClientQueue queue = ClientQueue.getInstance();

        CallCenter callCenter = new CallCenter(queue);
        Thread techSupport = new Thread(callCenter);
        techSupport.start();

        Thread.sleep(DELAY);

        for (int i = 0; i < MANAGERS_DEPT_SIZE; i++) {
            executor.execute(new Manager(queue));
            Thread.sleep(DELAY);
        }

        executor.shutdown();

        while (!executor.awaitTermination(DELAY, TimeUnit.MILLISECONDS)) {
        }

        System.out.println("Команда техподдержки сегодня хорошо поработала.");
    }
}
