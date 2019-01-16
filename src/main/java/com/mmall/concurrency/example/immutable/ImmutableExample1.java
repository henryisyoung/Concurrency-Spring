package com.mmall.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private static final Integer a = 1;
    private static final String b = "2";
    private static final Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
//        a = 2;
//        b = "c";
//        map = Maps.newHashMap();
        map.put(1,4);
        log.info("{}",map.get(1));
    }

    private void test(final int a) {
//        a = 1;
    }
}
