package com.vaka.epam.homework.week2.task10;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Map;
import java.util.Set;

/**
 * Created by Iaroslav on 11/9/2016.
 */
// Создать класс Department с внутренним классом, с помощью объектов
// которого можно хранить информацию обо всех должностях отдела и
// обо всех сотрудниках, когда-либо занимавших конкретную должность.
@Getter
public class Department {
    private DepartmentInfo depInfo;

    @Getter
    @AllArgsConstructor
    class DepartmentInfo {
        private Map<String, Set<Employee>> positionsEmployee;
        private Set<String> positions;
    }

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")
    class Employee {
        private Integer id;
        private boolean current;
        private String email;
        //some info
    }

}
