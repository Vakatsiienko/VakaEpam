package com.vaka.epam.lab1.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * Created by iaroslav on 18.11.16.
 */
@Getter
@Setter
@EqualsAndHashCode
public abstract class BaseEntity {
    private Optional<Integer> id;

}
