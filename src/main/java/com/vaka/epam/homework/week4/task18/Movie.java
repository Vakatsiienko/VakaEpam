package com.vaka.epam.homework.week4.task18;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Iaroslav on 11/19/2016.
 */
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class Movie {

    private String name;

    private AudioTrack audioTrack;

    private Subtitles subtitles;



    public Movie(String name, AudioTrack audioTrack, Subtitles subtitles) {
        this.name = name;
        this.audioTrack = audioTrack;
        this.subtitles = subtitles;
    }


}
