package com.synec.wordcounterservice.service;

import com.synec.wordcounterlib.impl.WordCounterImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WordCounterService {

    private final WordCounterImpl wordCounter;

    public void add(String word) {
        wordCounter.add(word);
    }

    public Integer getCount(String word) {
        return wordCounter.getCount(word);
    }
}
