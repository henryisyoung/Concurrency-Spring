package com.mmall.concurrency.example.concurrent;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class CopyOnWriteArrayListExample {
    // Total number of thread for requesting
    public static int threadTotal = 200;

    // Total number of requesting
    public static int clientTotal = 5000;

    public static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorServicecutors = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0; i < clientTotal; i++){
            executorServicecutors.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorServicecutors.shutdown();
        log.info("size:{}",list.size());
    }

    private static void add(){
        list.add(1);
    }
}
