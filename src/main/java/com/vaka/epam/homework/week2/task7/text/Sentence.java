package com.vaka.epam.homework.week2.task7.text;


import java.util.*;

/**
 * Created by Iaroslav on 11/11/2016.
 */
public class Sentence {
    private Word[] words;
    private Map<Integer, Character> endMarks;

    private Sentence(int wordsCount) {
        words = new Word[wordsCount];
        endMarks = new HashMap<>();
    }

    public static Sentence parseSentence(String[] sentence) {
        String lastWord = sentence[sentence.length - 1];
        if (!endOfSentenceMark(lastWord))
            throw new SentenceException(
                    "Sentence should ends with proper punctual mark: '.' '?' '!', your mark: "
                            + lastWord.charAt(lastWord.length() - 1));

        Sentence newSentence = new Sentence(sentence.length);
        for (int i = 0; i < sentence.length; i++) {
            if (i < sentence.length - 1 && endOfSentenceMark(sentence[i]))
                throw new SentenceException("There cannot be end mark in the middle of sentence. Your sentence: " + sentence[i]);
            else if (endWithMark(sentence[i])) {
                newSentence.endMarks.put(i, sentence[i].charAt(sentence[i].length() - 1));
                newSentence.words[i] = new Word(sentence[i]
                        .substring(0, sentence[i].length() - 1));
            } else
                newSentence.words[i] = new Word(sentence[i]);
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
