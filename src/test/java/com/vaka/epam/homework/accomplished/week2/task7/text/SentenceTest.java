package com.vaka.epam.homework.accomplished.week2.task7.text;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Iaroslav on 11/13/2016.
 */
public class SentenceTest {

    @Test
    public void testParseSentence() throws Exception {
        String goodSentence = "Some sentence, with end mark.";
        String wOutEndMark = "Some sentence, without mark";
        Sentence sentence = Sentence.parseSentence(goodSentence.split(" "));
        Assert.assertEquals(goodSentence, sentence.toString());
        //TODO ask about testing realisation(content of words list and marks map)

        //expecting SentenceException
        try {
            Sentence.parseSentence(wOutEndMark.split(" "));
            Assert.fail();
        } catch (SentenceException expected) {

        }
        String coupleSentences = "Java test. Hello world! Whatcha? Ok, nevermind.";
        try {
            Sentence.parseSentence(coupleSentences.split(" "));
            Assert.fail();
        } catch (SentenceException expected) {

        }
    }

    @Test(expected = SentenceException.class)
    public void testParseContent() throws Exception {
        String goodText = "Java test. Hello world! Whatcha? Ok, nevermind.";
        List<Sentence> sentences = Sentence.parseContent(goodText);
        Assert.assertEquals("Java test.", sentences.get(0).toString());
        Assert.assertEquals("Hello world!", sentences.get(1).toString());
        Assert.assertEquals("Whatcha?", sentences.get(2).toString());
        Assert.assertEquals("Ok, nevermind.", sentences.get(3).toString());

        String badText = "Java test. Hello world! Whatcha? Ok, nevermind. Bad text";
        //expecting SentenceException
        Sentence.parseContent(badText);
    }

    @Test
    public void testToString() throws Exception {
        String expected = "Some Hello World string.";
        Sentence sentence = Sentence.parseSentence(expected.split(" "));
        Assert.assertEquals(expected, sentence.toString());
    }
}
