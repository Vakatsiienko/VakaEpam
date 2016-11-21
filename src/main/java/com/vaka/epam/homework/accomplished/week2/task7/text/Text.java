package com.vaka.epam.homework.accomplished.week2.task7.text;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Iaroslav on 11/9/2016.
 */
// Создать объект класса Текст, используя классы Предложение,Слово.
// Методы: дополнить текст, вывести на консоль текст, заголовок текста.
@Getter
@Setter
public class Text {

    private Optional<String> header;
    private List<Sentence> content;

    private Text() {
    }

    public static Text buildFull(String header, String content) {
        Text text = new Text();
        text.header = Optional.of(header);
        text.content = Sentence.parseContent(content);
        return text;
    }

    public static Text buildEmpty() {
        Text text = new Text();
        text.header = Optional.empty();
        text.content = new ArrayList<>();
        return text;
    }

    public void appendText(String text) {
        content.addAll(Sentence.parseContent(text));
    }//TODO ask about return this;

    public String getConcatContent() {
        StringBuilder stringBuilder = new StringBuilder();
        content.forEach(sentence -> {
            stringBuilder.append(sentence);
            stringBuilder.append(" ");
        });
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void printHeader() {
        System.out.println(header);
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        if (header.isPresent()) {
            return String.join("\r\n", header.get(), getConcatContent());
        }
        return getConcatContent();
    }
}
