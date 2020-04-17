package com.kinetix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class WordCounterTest {

    /**
     * Test to check the alphabet only word.
     * expected True
     */
    @Test
    public void isStringOnlyAlphabet_alphabets() {

        assertTrue(new WordCounter().isStringOnlyAlphabet("Hello"));
    }

    /**
     * Test to check the non alphabet word.
     * expected False
     */
    @Test
    public void isStringOnlyAlphabet_nonAlphabets() {

        assertFalse(new WordCounter().isStringOnlyAlphabet("Hello123"));
    }

    /**
     * Test to check the alpahbet word with foreign alphabets
     */
    @Test
    public void isStringOnlyAlphabet_foreignAlphabets() {

        assertTrue(new WordCounter().isStringOnlyAlphabet("Heæålloñ"));
    }

    /**
     * Test to add the new or first time word
     */
    @Test
    public void addWord_newWord() {

        WordCounter wc = new WordCounter();
        wc.addWord("Hello");
        assertEquals(1, wc.wordCountMap.size());
        assertEquals( Integer.valueOf(1) , wc.wordCountMap.get("Hello"));

    }

    /**
     * Test to add the duplicate word with different case.
     * expected result is both word stored as same key and count is incremented.
     */
    @Test
    public void addWord_duplicateWordDiffCase() {

        WordCounter wc = new WordCounter();
        wc.addWord("Hello");
        wc.addWord("HELLO");
        assertEquals(1, wc.wordCountMap.size());
        assertEquals( Integer.valueOf(2) , wc.wordCountMap.get("hELLo"));

    }

    /**
     * Test to add the duplicate foreign word with different case.
     * expected result is both word stored as same key and count is incremented .
     */
    @Test
    public void addWord_duplicateWordDiffCaseForeign() {

        WordCounter wc = new WordCounter();
        wc.addWord("Heæålloñ");
        wc.addWord("HeæålloÑ");
        assertEquals(1, wc.wordCountMap.size());
        assertEquals( Integer.valueOf(2) , wc.wordCountMap.get("HeæålloÑ"));

    }

    /**
     * Test to add non-alphabets character.
     * expected result is throws exception with string "word must be non-alphabets:"
     */
    @Test
    public void addWord_nonAlphabets() {

        WordCounter wc = new WordCounter();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            wc.addWord("hello11");
        });

        String expectedMessage = "word must be non-alphabets:";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Test to add space.
     * expected result is throws exception with string "word must be non-alphabets:"
     */
    @Test
    public void addWord_blank() {

        WordCounter wc = new WordCounter();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            wc.addWord("  ");
        });

        String expectedMessage = "word must be non-alphabets:";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Test to add null.
     * expected result is throws exception with string "word must be non-alphabets:"
     */
    @Test
    public void addWord_null() {

        WordCounter wc = new WordCounter();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            wc.addWord(null);
        });

        String expectedMessage = "word must be non-alphabets:";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * Test to add the new or first time word
     * expected count is 1
     */
    @Test
    public void getCount_newWord() {

        WordCounter wc = new WordCounter();
        wc.addWord("Hello");
        assertEquals( Integer.valueOf(1) , wc.getCount("Hello"));
    }

    /**
     * Test to add duplicate word with different case.
     * expected count is 2
     */
    @Test
    public void getCount_duplicateWordwithCase() {

        WordCounter wc = new WordCounter();
        wc.addWord("Hello");
        wc.addWord("hello");
        assertEquals( Integer.valueOf(2) , wc.getCount("hELlo"));
    }

}