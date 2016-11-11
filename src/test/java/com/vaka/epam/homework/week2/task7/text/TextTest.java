package com.vaka.epam.homework.week2.task7.text;

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
        text.appendText("Hello World! Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible.");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        text.printAll();
        System.out.flush();
        System.setOut(old);
        System.out.println("Here: " + baos.toString());
    }
}
