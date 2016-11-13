package com.vaka.epam.homework.week2.task7.text;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;


/**
 * Created by Iaroslav on 11/11/2016.
 */
public class TextTest {
    @Test
    public void testGetConcatContent() throws Exception {
        String header = "Java wiki.";
        String content = "Java test. Hello world! Whatcha? Ok, nevermind.";
        Text text = Text.buildFull(header, content);

        String expected = "Java wiki.\r\nJava test. Hello world! Whatcha? Ok, nevermind.";

        Assert.assertEquals(expected, text.getConcatContent());
    }

    @Test
    public void testAppendText() throws Exception {
        String header = "Java wiki.";
        String content = "Java test. Hello world!";
        Text text = Text.buildFull(header, content);

        text.appendText("Whatcha? Ok, nevermind.");
        String newContent = "Java test. Hello world! Whatcha? Ok, nevermind.";
        Assert.assertEquals(newContent, text.getConcatContent());
    }

    @Test
    public void testBuildEmpty() throws Exception {
        Text text = Text.buildEmpty();
        Assert.assertFalse(text.getHeader().isPresent());
        Assert.assertTrue(text.getContent().isEmpty());
    }

    @Test
    public void testBuildFull() throws Exception {
        String header = "Java wiki.";
        String content = "Java test. Hello world! Whatcha? Ok, nevermind.";
        Text text = Text.buildFull(header, content);
        Assert.assertEquals(header, text.getHeader().get());
        Assert.assertEquals(content, text.getConcatContent());
    }

    @Test
    public void testToString() throws Exception {
        String header = "Java wiki.";
        String content = "Java test. Hello world!";
        String withHeader = String.join("\r\n", "Java wiki.", "Java test. Hello world!");
        Text text = Text.buildEmpty();
        text.appendText(content);
        //test wOut header
        Assert.assertEquals(content, text.toString());

        text.setHeader(Optional.of(header));
        Assert.assertEquals(withHeader, text.toString());
    }
}
