package com.mmall.concurrency.example.publish;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnsafePublish {
    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("states {}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info("states {}", Arrays.toString(unsafePublish.getStates()));
    }

    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }
}
