package com.vaka.epam.homework.week2.task7.text;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Iaroslav on 11/11/2016.
 */
public class TextTest {
    @Test
    public void testAppendText() throws Exception {
        Text text = new Text("Java wiki");
        String test = "Java test. Hello world!";
        text.appendText(test);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        text.printAll();
        System.out.flush();
        System.setOut(old);
        Assert.assertEquals(baos.toString(), test);
    }
}
