package org.codeship.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "- printing from a different thread than org.codeship.main.Main");
     }
}

public class RunnableExample {

    private static ExecutorService executorService = Executors.newFixedThreadPool(3);
    public static void main(String[] args) {
        RunnableImpl task = new RunnableImpl();
        Thread thread = new Thread(task);
        thread.start();
        // Running runnable task using Executor Service.
        for(int i = 1; i <= 1000; i++) {
            executorService.submit(task);
        }
    }
}
