package com.vaka.epam.homework.week2.task10;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Iaroslav on 11/13/2016.
 */

// Создать класс Cправочная Cлужба Oбщественного Tранспорта с внутренним классом,
// с помощью объектов которого можно хранить информацию о времени, линиях маршрутов и стоимости проезда.
public class TransportHelpdesk {

    private Map<Integer, RouteInfo> routesInfo;

    private class RouteInfo {
        private Map<String, Set<LocalTime>> stationsTime;
        private List<String> stations;
        private double fee;

        public List<LocalTime> getStationTime(String station) {
            return stationsTime.get(station).stream()
                    .sorted()
                    .collect(Collectors.toList());
        }
    }
}
