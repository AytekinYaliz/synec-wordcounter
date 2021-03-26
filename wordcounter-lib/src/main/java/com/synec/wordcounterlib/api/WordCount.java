package com.synec.wordcounterlib.api;

import java.util.concurrent.atomic.AtomicInteger;

public class WordCount {

    private String word;
    private AtomicInteger count;

    public WordCount(String word) {
        this.word = word;
        count = new AtomicInteger(0);
    }


    public void increment() {
        count.incrementAndGet();
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count.get();
    }

    @Override
    public String toString() {
        return word != null ? word.toUpperCase() : null;
    }
}
