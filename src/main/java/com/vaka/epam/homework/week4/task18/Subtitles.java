package com.vaka.epam.homework.week4.task18;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;

/**
 * Created by Iaroslav on 11/19/2016.
 */
@NoArgsConstructor
@Getter
public class Subtitles {

    private Language language;

    public Subtitles(Language language) {
        this.language = language;
    }

}
