package com.swd.concurrent.concurrent.singleton;

import com.swd.concurrent.annoations.NotRecommend;
import com.swd.concurrent.annoations.ThreadSafe;

@ThreadSafe
@NotRecommend
public class SingletonExample2 {

    private static SingletonExample2 singleton = new SingletonExample2();

    private SingletonExample2(){};

    public static SingletonExample2 getInstance(){
        return singleton;
    }
}
