package com.swd.concurrent.concurrent.singleton;

import com.swd.concurrent.annoations.ThreadUnSafe;

@ThreadUnSafe
public class SingletonExample1 {

    private static SingletonExample1 singleton = null;

    private  SingletonExample1(){};

    public static SingletonExample1 getInstance(){
        if(singleton == null){
            singleton = new SingletonExample1();
        }
        return singleton;
    }
}
