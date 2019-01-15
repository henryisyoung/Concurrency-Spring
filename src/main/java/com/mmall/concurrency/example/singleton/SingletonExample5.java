package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NotRecommend;
import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;

@ThreadSafe
public class SingletonExample5 {

    // private constructor
    private SingletonExample5() {

    }

    // 1 allocate memory space
    // 2 construct instances
    // 3 point instances to the allocated space

    // JVM and CPU could rearrange the order of command like this

    // singleton instance (volatile can avoid re-order)
    private static volatile SingletonExample5 instance = null;

    //static factory method to get the static instance
    public static SingletonExample5 getInstance() {
        if(instance == null) { // B - 2 but B would get a "instance memory without valid content" so return result directly
            synchronized(SingletonExample5.class){
                if(instance == null) {
                    instance = new SingletonExample5(); // A - 3
                }
            }
        }
        return instance;
    }
}
