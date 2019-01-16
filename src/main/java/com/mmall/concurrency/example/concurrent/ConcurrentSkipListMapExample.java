package com.mmall.concurrency.example.concurrent;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

@Slf4j
@ThreadSafe
public class ConcurrentSkipListMapExample {
    // Total number of thread for requesting
    public static int threadTotal = 200;

    // Total number of requesting
    public static int clientTotal = 5000;

    public static Map<Integer, Integer> map = new ConcurrentSkipListMap<>();

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
