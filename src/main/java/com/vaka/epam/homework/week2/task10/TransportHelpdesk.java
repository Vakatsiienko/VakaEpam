package com.vaka.epam.homework.week2.task10;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;

/**
 * Created by Iaroslav on 11/9/2016.
 */

// Создать класс Cправочная Cлужба Oбщественного Tранспорта с внутренним классом,
// с помощью объектов которого можно хранить информацию о времени, линиях маршрутов и стоимости проезда.
@Getter
@AllArgsConstructor
public class TransportHelpdesk {

    private Map<Integer, RouteInfo> routesInfo;

    @Getter
    @AllArgsConstructor
    private class RouteInfo {
        private Map<String, SortedSet<LocalTime>> arrivalTimeByStationName;
        private List<String> stations;
        private final double fee;
    }
}
