package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annoations.NotRecommend;
import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;

@NotThreadSafe
@NotRecommend
public class SingletonExample4 {

    // private constructor
    private SingletonExample4() {

    }

    // 1 allocate memory space
    // 2 construct instances
    // 3 point instances to the allocated space

    // JVM and CPU could rearrange the order of command like this

    // 1 allocate memory space
    // 3 point instances to the allocated space
    // 2 construct instances

    // singleton instance
    private static SingletonExample4 instance = null;

    //static factory method to get the static instance
    public static SingletonExample4 getInstance() {
        if(instance == null) { // B - 2 but B would get a "instance memory without valid content" so return result directly
            synchronized(SingletonExample4.class){
                if(instance == null) {
                    instance = new SingletonExample4(); // A - 3
                }
            }
        }
        return instance;
    }
}
