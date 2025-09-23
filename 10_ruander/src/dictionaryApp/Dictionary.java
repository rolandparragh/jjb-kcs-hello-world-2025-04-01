package dictionaryApp;

import java.util.Map;

public class Dictionary {
    private Map<String, String> words;

    public Dictionary(Map<String, String> words) {
        this.words = words;
    }

    public String translate(String word) {
        return words.get(word);
    }

    public boolean contains(String word) {
        return words.containsKey(word);
    }
}
