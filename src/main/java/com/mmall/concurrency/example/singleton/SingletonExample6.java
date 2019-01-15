package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.ThreadSafe;

@ThreadSafe
public class SingletonExample6 {

    // private constructor
    private SingletonExample6() {

    }

    // singleton instance
    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    //static factory method to get the static instance
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());

    }
}
