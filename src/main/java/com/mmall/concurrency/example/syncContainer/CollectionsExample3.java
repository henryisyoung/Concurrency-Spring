package com.mmall.concurrency.example.syncContainer;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadSafe
public class CollectionsExample3 {
    // Total number of thread for requesting
    public static int threadTotal = 200;

    // Total number of requesting
    public static int clientTotal = 5000;

    public static Map<Integer, Integer> map = Collections.synchronizedMap(new Hashtable<>());

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorServicecutors = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0; i < clientTotal; i++){
            final int count = i;
            executorServicecutors.execute(() -> {
                try {
                    semaphore.acquire();
                    add(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorServicecutors.shutdown();
        log.info("size:{}", map.size());
    }

    private static void add(int count){
        map.put(count,count);
    }
}
