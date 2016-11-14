package com.vaka.epam.homework.week2.task7.text;


import java.util.*;

/**
 * Created by Iaroslav on 11/9/2016.
 */
public class Sentence {
    private Word[] words;
    private Map<Integer, Character> endMarks;

    private Sentence(int wordsCount) {
        words = new Word[wordsCount];
        endMarks = new HashMap<>();
    }

    public static Sentence parseSentence(String[] words) {
        String lastWord = words[words.length - 1];
        if (!endOfSentenceMark(lastWord))
            throw new SentenceException(
                    "Sentence should ends with proper punctual mark: '.' '?' '!', your mark: "
                            + lastWord.charAt(lastWord.length() - 1));

        Sentence newSentence = new Sentence(words.length);
        for (int i = 0; i < words.length; i++) {
            if (i < words.length - 1 && endOfSentenceMark(words[i]))
                throw new SentenceException("There cannot be end mark in the middle of sentence. Your sentence: " + words[i]);
            else if (endWithMark(words[i])) {
                newSentence.endMarks.put(i, words[i].charAt(words[i].length() - 1));
                newSentence.words[i] = new Word(words[i]
                        .substring(0, words[i].length() - 1));
            } else
                newSentence.words[i] = new Word(words[i]);
        }
        return newSentence;
    }

    public static List<Sentence> parseContent(String text) {
        if (!endOfSentenceMark(text))
            throw new SentenceException("Sentence should ends with proper punctual mark: '.' '?' '!', your mark: "
                    + text.charAt(text.length() - 1));
        String[] words = text.split(" ");
        List<Sentence> sentences = new ArrayList<>(words.length / 10);
        int startI = 0;
        for (int i = 0; i < words.length; i++) {
            if (endOfSentenceMark(words[i])) {
                sentences.add(
                        parseSentence(
                                Arrays.copyOfRange(words, startI, i + 1)));
                startI = i + 1;
            }
        }
        return sentences;
    }

    public static boolean endOfSentenceMark(String str) {
        char last = str.charAt(str.length() - 1);
        return last == '.' || last == '!' || last == '?';
    }

    private static boolean endWithMark(String str) {
        char last = str.charAt(str.length() - 1);
        return last == '.' || last == '!' || last == '?' || last == ',';
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            builder.append(words[i]);
            if (endMarks.containsKey(i))
                builder.append(endMarks.get(i));
            builder.append(" ");
        }
        builder.setLength(builder.length() - 1);

        return builder.toString();
    }

}
