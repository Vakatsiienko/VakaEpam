package com.vaka.epam.homework.week4.task19Prototype;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Iaroslav on 11/20/2016.
 */
@AllArgsConstructor
public class Wikipedia {

    public Wikipedia(Map<String, Article> articleByTitle) {
        this.articleByTitle = articleByTitle;
        articleByTitleBeforeUpdate = new HashMap<>();
    }

    private Map<String, Article> articleByTitle;

    private Map<String, Article> articleByTitleBeforeUpdate;


    public Article getArticleForEdit(String name) {
        return articleByTitle.get(name).createCopy();
    }

    public void updateArticle(Article article) {
        articleByTitleBeforeUpdate.put(article.getTitle(), articleByTitle.get(article.getTitle()));
        articleByTitle.put(article.getTitle(), article);
    }

    public boolean undoUpdate(Article article) {
        if (articleByTitleBeforeUpdate.containsKey(article.getTitle())) {
            articleByTitle.put(article.getTitle(), articleByTitleBeforeUpdate.get(article.getTitle()));
            return true;
        } else return false;
    }
}
