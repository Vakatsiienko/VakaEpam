package com.vaka.epam.homework.accomplished.week2.task10;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by Iaroslav on 11/9/2016.
 */
// Создать класс Catalog с внутренним классом,
// с помощью объектов которого можно хранить информацию об истории выдач книги читателям.
@Getter
@AllArgsConstructor
public class Catalog {

    private Map<Integer, BookHistory> bookHistoryMapById;

    @Getter
    @AllArgsConstructor
    class BookHistory {
        private SortedMap<LocalDate, Integer> issues;
        private SortedMap<LocalDate, Integer> returns;
    }
}
