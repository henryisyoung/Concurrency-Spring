package com.mmall.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {

    // sync works for the block of code in { }
    public void test0() {
        for (int i = 0; i < 10; i++) {
            log.info("test0 : {}",i);
        }
    }

    // sync works for the block of code in { }
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 : {}",i);
            }
        }
    }

    // sync works for a method
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 : {}",i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test2();
        });
        executorService.execute(() -> {
            example1.test2();
        });
    }
}
