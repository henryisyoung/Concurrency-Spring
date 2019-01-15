package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NotThreadSafe;

@NotThreadSafe
public class SingletonExample1 {

    // private constructor
    private SingletonExample1() {

    }

    // singleton instance
    private static SingletonExample1 instance = null;

    //static factory method to get the static instance
    public static SingletonExample1 getInstance() {
        if(instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
