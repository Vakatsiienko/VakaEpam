package com.vaka.epam.homework.week4.task18;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * Created by Iaroslav on 11/19/2016.
 */
@Getter
@Setter
public class AudioTrack {

    private Language language;

    public AudioTrack(Language language) {
        this.language = language;
    }
}
