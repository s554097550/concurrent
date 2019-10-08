package com.swd.concurrent.concurrent.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample1 {

    // 修饰代码块，作用于调用对象
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1-{}-{}", j, i);
            }
        }
    }

    // 修饰方法，作用于调用对象
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2-{}-{}", j, i);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
//        executorService.execute(()->{
//            synchronizedExample1.test1(1);
//            synchronizedExample1.test2(1);
//        });
//        executorService.execute(()->{
//            synchronizedExample1.test1(2);
//            synchronizedExample1.test2(1);
//        });

        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        SynchronizedExample1 synchronizedExample12 = new SynchronizedExample1();
        executorService.execute(() -> {
            synchronizedExample1.test1(1);
            synchronizedExample1.test2(1);
        });
        executorService.execute(() -> {
            synchronizedExample12.test1(2);
            synchronizedExample12.test2(2);
        });

    }
}
