package com.vaka.epam.homework.week2.task7.text;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iaroslav on 11/11/2016.
 */
// Создать объект класса Текст, используя классы Предложение,Слово.
// Методы: дополнить текст, вывести на консоль текст, заголовок текста.
@Getter
@Setter
public class Text {

    private String header;
    private List<Sentence> sentences;

    public Text() {
        this.header = "";
        sentences = new ArrayList<>();
    }
    public Text(String header) {
        this.header = header;
        sentences = new ArrayList<>();
    }

    public void printAll() {
        System.out.println(header + "\n\r");
        sentences.forEach(sentence -> System.out.println(sentence + " "));
    }

    public void printHeader() {
        System.out.println(header);
    }

    public void appendText(String text) {
        String[] newSentences = text.split("(\\.)?!?(\\?)?");
        for (String newSentence : newSentences) {
            sentences.add(new Sentence(newSentence));
        }
    }


}
