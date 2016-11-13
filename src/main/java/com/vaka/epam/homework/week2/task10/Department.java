package com.vaka.epam.homework.week2.task10;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

/**
 * Created by Iaroslav on 11/13/2016.
 */
// Создать класс Department с внутренним классом, с помощью объектов
// которого можно хранить информацию обо всех должностях отдела и
// обо всех сотрудниках, когда-либо занимавших конкретную должность.
@Getter
public class Department {
    private DepartmentInfo depInfo;

    @Getter
    class DepartmentInfo {
        private Map<String, Employee> positionsEmployee;
        private Set<Employee> employees;
//        private Map<Employee, Map<String, Map<LocalDate, LocalDate>>> employeeInfo;
    }

    @Getter
    class Employee {
        private Integer id;
        private boolean current;
        private Map<String, Map<LocalDate, LocalDate>> positions;
        private String email;
        //some info
    }

}
