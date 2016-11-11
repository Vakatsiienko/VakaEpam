package com.vaka.epam.homework.week2.task7.text;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iaroslav on 11/11/2016.
 */
public class Sentence {
    private List<Word> words = new ArrayList<>();

    public Sentence(String sentence) {
        String[] newWords = sentence.split(" ");
        for (String newWord : newWords) {
            words.add(new Word(newWord));
        }
    }

    public String buildSentence(){
        StringBuilder builder = new StringBuilder();
        for (Word word : words) {
            builder.append(word.getStr()).append(" ");
        }
        return builder.toString().trim();
    }

}
