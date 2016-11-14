package com.vaka.epam.homework.week2.task7.text;


import lombok.Getter;

/**
 * Created by Iaroslav on 11/9/2016.
 */
@Getter
public class Word {
    private String str;

    public Word(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
