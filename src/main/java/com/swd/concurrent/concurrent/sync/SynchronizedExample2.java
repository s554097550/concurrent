package com.swd.concurrent.concurrent.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample2 {

    // 修饰类，作用于所有对象
    public void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1-{}-{}", j, i);
            }
        }
    }

    // 修饰静态方法，作用于所有对象
    public synchronized static void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2-{}-{}", j, i);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        SynchronizedExample2 synchronizedExample = new SynchronizedExample2();
//        executorService.execute(()->{
//            synchronizedExample.test1(1);
//            synchronizedExample.test2(1);
//        });
//        executorService.execute(()->{
//            synchronizedExample.test1(2);
//            synchronizedExample.test2(1);
//        });

        SynchronizedExample2 synchronizedExample = new SynchronizedExample2();
        SynchronizedExample2 synchronizedExample1 = new SynchronizedExample2();
        executorService.execute(() -> {
            synchronizedExample.test1(1);
            synchronizedExample.test2(1);
        });
        executorService.execute(() -> {
            synchronizedExample1.test1(2);
            synchronizedExample1.test2(2);
        });

    }
}
