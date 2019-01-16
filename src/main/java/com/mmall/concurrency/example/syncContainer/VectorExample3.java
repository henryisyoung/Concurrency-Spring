package com.mmall.concurrency.example.syncContainer;

import com.mmall.concurrency.annoations.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;

@NotThreadSafe
public class VectorExample3 {
    private static void test1(Vector<Integer> vector) {
        for (Integer i : vector){
            if(i.equals(3)) vector.remove(i);
        }
    }

    private static void test2(Vector<Integer> vector) {
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            if(i.equals(3)) vector.remove(i);
        }
    }

    private static void test3(Vector<Integer> vector) {
        for(int i = 1; i < 4; i++){
            if(i == 3) vector.remove(i);
        }
    }
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(3);
        vector.add(2);
        test2(vector);
    }
}
