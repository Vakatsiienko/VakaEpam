package com.vaka.epam.homework.week4.task22Observer;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Iaroslav on 11/22/2016.
 */
@Getter
@AllArgsConstructor
public class NewsMediaPrint {

    private NewsMediaType mediaType;

    private String edition;

    private String content;
}
