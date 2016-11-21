package com.vaka.epam.homework.week4.task19Prototype;

import lombok.AllArgsConstructor;
import java.util.Map;

/**
 * Created by Iaroslav on 11/20/2016.
 */
@AllArgsConstructor
public class Wikipedia {

    private Map<String, Article> articlesByTitle;


    public Article getArticleForEdit(String name) {
        return articlesByTitle.get(name).createCopy();
    }

    public void updateArticle(Article article){
        articlesByTitle.put(article.getTitle(), article);
    }
}
