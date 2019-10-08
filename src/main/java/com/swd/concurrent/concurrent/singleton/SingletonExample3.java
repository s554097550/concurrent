package com.swd.concurrent.concurrent.singleton;

import com.swd.concurrent.annoations.NotRecommend;
import com.swd.concurrent.annoations.ThreadSafe;

@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private static SingletonExample3 singleton = null;

    private SingletonExample3(){}

    public static synchronized SingletonExample3 getInstance(){
        if(singleton == null){
            singleton = new SingletonExample3();
        }
        return singleton;
    }
}
