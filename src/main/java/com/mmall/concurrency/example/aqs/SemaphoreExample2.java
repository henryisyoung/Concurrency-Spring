package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample2 {

    public final static int threadCount = 20;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);

        for(int i = 0; i < threadCount; i++){
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire(3); // get many permission
                    test(threadNum);
                    semaphore.release(3); // release many permission
                } catch (Exception e) {
                    log.error("Exception",e);
                } finally {
                }
            });
        }
        log.info("Finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        log.info("{}",threadNum);
        Thread.sleep(100);
    }
}
