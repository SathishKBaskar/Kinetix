package com.kinetix;

import org.apache.commons.collections4.map.CaseInsensitiveMap;

import java.util.Map;

/**
 * Class to count the Word no, of times it added.
 * CaseInsensitiveMap used to store the words.
 */
public class WordCounter {

    Map<String, Integer> wordCountMap = new CaseInsensitiveMap<>();

    /**
     * Method checks the string is only alphabet.
     * The condition should include alphabet from other languages.
     * return true is its only alphabets else return false.
     * @param str String
     * @return
     */
    boolean isStringOnlyAlphabet(String str) {

        if (str == null || str.trim().equals("")){
            return false;
        }

        return ((str != null)
                && (str.matches("^[\\p{L}]*$")));
    }

    /**
     * Method adds the word to MAP as key and value as no, of times the word is added.
     * The case of the word is ignored.
     * todo: Translate the word.
     *
     * @param word
     */
     void addWord(String word){

        if (isStringOnlyAlphabet(word)) {
            wordCountMap.merge(word,1,Integer::sum);

        }else {
            throw new IllegalArgumentException("word must be non-alphabets: "+word);
        }
    }

    /**
     * Method returns the count for the given word.
     * todo: Translate the word.
     * @param word
     * @return
     */
    Integer getCount(String word){
        return wordCountMap.get(word);
    }


}