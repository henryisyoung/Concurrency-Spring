package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NotRecommend;
import com.mmall.concurrency.annoations.ThreadSafe;

@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // private constructor
    private SingletonExample3() {

    }

    // singleton instance
    private static SingletonExample3 instance = null;

    //static factory method to get the static instance
    public static synchronized SingletonExample3 getInstance() {
        if(instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
