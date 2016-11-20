package com.vaka.epam.lab1.domain.vegetable;

import com.vaka.epam.lab1.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

/**
 * Created by iaroslav on 18.11.16.
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class Vegetable extends BaseEntity{
    private Optional<Integer> calories;
}
