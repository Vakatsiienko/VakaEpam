package com.vaka.epam.homework.week4.task19;

import lombok.AllArgsConstructor;
import java.util.Map;

/**
 * Created by Iaroslav on 11/20/2016.
 */
@AllArgsConstructor
public class Wikipedia {

    private Map<String, Article> articlesByName;


    public Article getArticleForEdit(String name) {
        return articlesByName.get(name).createCopy();
    }
}
