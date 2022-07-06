package com.joaovitor.newsscraper.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class WordFinder {    

    public static Set<String> searchValidWords(List<String> text) {

        Set<String> words = new HashSet<>();

        for (String paragraph : text) {
            for (String word : paragraph.split(" ")) {

                word = word.toLowerCase();

                if ( isValidWord(word) ) {

                    word = wordCleaner(word);
                    words.add(word);

                }
            }
        }

        return words;
    }

    private static String wordCleaner(String word) {
        while (true) {
            if (startsWithInvalidLetter(word)) {
                word = firstLetterCleanup(word);
            }
            if (endsWithInvalidLetter(word)) {
                word = lastLetterCleanup(word);
            }
            if (isWordCleaned(word)) {
                return word;
            }
        }
    }

    private static boolean isValidWord(String word) {
        boolean isValid = true;
        for( String pattern : ValidWordPatterns.PATTERNS ) {
            if ( word.matches(pattern) ) {
                continue;
            } else{
                isValid = false;
            }
        }

        return isValid;
    }

    private static boolean isWordCleaned(String word) {
        boolean validStart = !startsWithInvalidLetter(word);
        boolean validEnd = !endsWithInvalidLetter(word);
        if (validStart && validEnd) {
            return true;
        }
        return false;
    }

    private static String firstLetterCleanup(String word) {
        return word.substring(1);
    }

    private static String lastLetterCleanup(String word) {
        int lastLetterIndex = word.length() - 1;
        return word.substring(0, lastLetterIndex);
    }

    private static boolean startsWithInvalidLetter(String word) {
        String letter = Character.toString(word.charAt(0));
        if (letter.matches("\\W")) {
            return true;
        }
        return false;
    }

    private static boolean endsWithInvalidLetter(String word) {
        int index = word.length() - 1;
        String letter = Character.toString(word.charAt(index));
        if (letter.matches("\\W")) {
            return true;
        }
        return false;
    }
    
    
}
