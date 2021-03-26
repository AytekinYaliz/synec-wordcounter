package com.synec.wordcounterlib.api;

import com.synec.wordcounterlib.exception.InvalidWordException;
import com.synec.wordcounterlib.exception.NotARealWordException;

public interface WordCounter {
    void add(String word) throws InvalidWordException, NotARealWordException;
    int getCount(String word) throws InvalidWordException, NotARealWordException ;
}
