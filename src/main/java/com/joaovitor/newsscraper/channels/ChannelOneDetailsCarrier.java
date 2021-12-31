package com.joaovitor.newsscraper.channels;

import java.util.List;
import java.util.Set;

public class ChannelOneDetailsCarrier {

    private String title;
    private List<String> text;
    private Set<String> words;

    public ChannelOneDetailsCarrier(String title, List<String> text, Set<String> words) {
        this.title = title;
        this.text = text;
        this.words = words;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getText() {
        return text;
    }

    public Set<String> getWords() {
        return words;
    }

}
