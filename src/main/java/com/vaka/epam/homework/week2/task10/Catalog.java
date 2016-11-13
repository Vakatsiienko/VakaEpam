package com.vaka.epam.homework.week2.task10;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Iaroslav on 11/13/2016.
 */
// Создать класс Catalog с внутренним классом,
// с помощью объектов которого можно хранить информацию об истории выдач книги читателям.
@Getter
public class Catalog {

    private Map<Integer, BookHistory> bookHistoryMap;

    @Getter
    class BookHistory {
        private TreeMap<LocalDate, Integer> issues;
        private TreeMap<LocalDate, Integer> returns;
    }
}
