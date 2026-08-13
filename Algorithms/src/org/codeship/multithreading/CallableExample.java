package org.codeship.multithreading;


import java.util.concurrent.*;

class CallableMessage implements Callable<String> {

    @Override
    public String call() throws Exception {
        return (Thread.currentThread().getName() + "- Overriding method from callable message class");
    }
}
public class CallableExample {

    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws Exception {
        CallableMessage task = new CallableMessage();
        for (int i = 0; i < 1000; i++) {
            Future<String> submit = executorService.submit(task);
            System.out.println(Thread.currentThread().getName() + " - " + submit.get());
        }
    }
}
