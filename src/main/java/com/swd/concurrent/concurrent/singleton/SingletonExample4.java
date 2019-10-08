package com.swd.concurrent.concurrent.singleton;

import com.swd.concurrent.annoations.Recommend;
import com.swd.concurrent.annoations.ThreadSafe;

@ThreadSafe
@Recommend
public class SingletonExample4 {

    private static volatile SingletonExample4 singleton = null;

    private SingletonExample4(){};

    public static SingletonExample4 getInstance(){
        if(singleton == null){
            synchronized (SingletonExample4.class){
                if(singleton == null){
                    singleton = new SingletonExample4();
                }
            }
        }
        return singleton;
    }
}
