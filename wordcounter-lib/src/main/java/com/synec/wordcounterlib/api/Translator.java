package com.synec.wordcounterlib.api;

// public interface Translator {
//     String translate(String word);
// }

import java.util.HashMap;
import java.util.Map;

public class Translator {

    private Map<String, String> translations = new HashMap<>();

    public Translator() {
        translations.put("flower", "flower");
        translations.put("blume", "flower");
        translations.put("flor", "flower");

        translations.put("table", "table");
        translations.put("tableDE", "table");
        translations.put("tableES", "table");

        translations.put("car", "car");
        translations.put("carDE", "car");
        translations.put("carES", "car");
    }

    public String translate(String word) {
        return translations.get(word);
    }
}
