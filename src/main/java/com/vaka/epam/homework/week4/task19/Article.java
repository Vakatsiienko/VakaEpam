package com.vaka.epam.homework.week4.task19;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
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
    private String[] chapters;
    private String[] href;
    private List<Byte[]> files;

    @Override
    public Article createCopy() {
        Article article = new Article();
        article.title = title;
        article.description = description;
        article.summary = summary;
        article.chapters = chapters;
        //TODO add ArraysCopy
        article.href = href;
        article.files = new ArrayList<>();
        Collections.copy(article.files, files);
        return article;
    }
}
