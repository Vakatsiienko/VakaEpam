package com.vaka.epam.homework.accomplished.week2.task7.starsystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Created by Iaroslav on 11/9/2016.
 */
@Getter
@AllArgsConstructor
public class Planet {
    private final String uid;
    private List<Satellite> satellites;
}
