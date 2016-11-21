package com.vaka.epam.homework.week4.task18;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Iaroslav on 11/19/2016.
 */
//18. Паттерн Abstract Factory. Разработать систему Кинопрокат. Пользователь мо
//        жет выбрать определенную киноленту, при заказе киноленты указывается язык
//        звуковой дорожки, который совпадает с языком файла субтитров. Система
//        должна поставлять фильм с требуемыми характеристиками, причем при смене
//        языка звуковой дорожки должен меняться и язык файла субтитров и наоборот.
public class MovieFabric {

    private static MovieFabric instance;

    private MovieFabric() {
    }

    public static MovieFabric getInstance() {
        if (instance == null) {
            synchronized (MovieFabric.class) {
                if (instance == null)
                    instance = new MovieFabric();
            }
        }
        return instance;
    }


    public Movie getMovie(String name, Language language) {
        AudioTrack track = new AudioTrack(language);
        Subtitles subtitles = new Subtitles(language);
        return new Movie(name, track, subtitles);
    }

}
