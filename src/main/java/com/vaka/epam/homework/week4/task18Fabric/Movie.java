package com.vaka.epam.homework.week4.task18Fabric;

import lombok.*;

/**
 * Created by Iaroslav on 11/19/2016.
 */
@Getter
public class Movie {

    private String name;

    private Resolution resolution;

    private AudioTrack audioTrack;

    private Subtitles subtitles;



    public Movie(String name, Resolution resolution, AudioTrack audioTrack, Subtitles subtitles) {
        this.name = name;
        this.resolution = resolution;
        this.audioTrack = audioTrack;
        this.subtitles = subtitles;
    }


}
