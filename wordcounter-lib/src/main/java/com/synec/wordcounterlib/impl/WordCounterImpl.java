package com.synec.wordcounterlib.impl;



import com.synec.wordcounterlib.exception.InvalidWordException;
import com.synec.wordcounterlib.exception.NotARealWordException;
import com.synec.wordcounterlib.api.Translator;
import com.synec.wordcounterlib.api.WordCount;
import com.synec.wordcounterlib.api.WordCounter;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class WordCounterImpl implements WordCounter {

    private ConcurrentHashMap<String, WordCount> usedWords;
    private Translator translator;

    public WordCounterImpl() {
        usedWords = new ConcurrentHashMap<>();
        translator = new Translator();
    }

    @Override
    public void add(String word) throws InvalidWordException, NotARealWordException {
        if(word == null || !word.matches("[a-zA-Z]+")) {
            throw  new InvalidWordException("The word should contain alphabetical characters only!");
        }

        String translation = translator.translate(word);

        if(translation == null) {
            throw new NotARealWordException("Not a real word!");
        }

        usedWords.compute(translation, (key, value) -> {
            value = (value == null ? new WordCount(translation) : value);
            value.increment();
            return value;
        });
    }

    @Override
    public int getCount(String word) throws InvalidWordException, NotARealWordException {
        if(word == null || !word.matches("[a-zA-Z]+")) {
            throw  new InvalidWordException("The word should contain alphabetical characters only!");
        }

        String translation = translator.translate(word);

        if(translation == null) {
            throw new NotARealWordException("Not a real word!");
        }

        WordCount usedWordCount = usedWords.get(translation);

        return usedWordCount == null ? 0 : usedWordCount.getCount();
    }

}
