package com.joaovitor.newsscraper.models;

import java.util.List;
import java.util.Set;

public class NewsDetails {
    
    private String title;
    private List<String> article;
    private Set<String> words;

    public NewsDetails(String title, List<String> article) {
        this.title = title;
        this.article = article;
        this.words = WordFinder.searchValidWords(article);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getArticle() {
        return article;
    }

    public Set<String> getWords() {
        return words;
    }

    
    
}
