package com.vaka.epam.homework.week4.task19Prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Iaroslav on 11/20/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Prototype{

    private String title;
    private String description;
    private String summary;
    private List<String> chapters;
    private List<String> href;
    private List<Byte[]> files;

    @Override
    public Article createCopy() {
        Article article = new Article();
        article.title = title;
        article.description = description;
        article.summary = summary;
        article.chapters = new ArrayList<>(chapters.size());
        Collections.copy(article.chapters, chapters);
        article.href = new ArrayList<>(href.size());
        Collections.copy(article.href, href);
        article.files = new ArrayList<>();
        Collections.copy(article.files, files);
        return article;
    }
}
