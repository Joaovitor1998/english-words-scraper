package com.joaovitor.newsscraper.scrapers;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public abstract class ScraperUtils {

    public static HtmlPage openWebPage(String url) {
        try (final WebClient webClient = new WebClient()) {

            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);

            HtmlPage page = webClient.getPage(url);

            return page;

        } catch (FailingHttpStatusCodeException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Set<String> lookUpForWords(List<String> text) {

        Set<String> words = new HashSet<>();

        for (String paragraph : text) {
            for (String word : paragraph.split(" ")) {

                word = word.toLowerCase();

                if (isValidWord(word)) {
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

        boolean patternOne = !word.matches("(http|www)(.*)|(.*)@(.*)");
        boolean patternTwo = !word.matches("\\W+$");
        boolean patternThree = word.matches("[a-z\\W]+$");
        if (patternOne && patternTwo && patternThree) {
            return true;
        }
        return false;
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