package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.ThreadSafe;

@ThreadSafe
public class SingletonExample2 {

    // private constructor
    private SingletonExample2() {

    }

    // singleton instance
    private static SingletonExample2 instance = new SingletonExample2();

    //static factory method to get the static instance
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
