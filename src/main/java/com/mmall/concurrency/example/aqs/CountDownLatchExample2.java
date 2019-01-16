package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownLatchExample2 {

    public final static int threadCount = 200;

    public static void main(String[] args) throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < threadCount; i++){
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    log.error("Exception",e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(10, TimeUnit.MICROSECONDS);
        log.info("Finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);

        log.info("{}",threadNum);
    }
}
