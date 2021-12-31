package com.joaovitor.newsscraper.dictionary.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Word {

    private String word;
    private String phonetic;
    private List<Phonetics> phonetics;
    private String origin;
    private List<Meaning> meanings;

    public Word() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    @JsonProperty("phonetics")
    public List<Phonetics> getPhonetics() {
        return phonetics;
    }

    @JsonProperty("phonetics")
    public void setPhonetics(List<Phonetics> phonetics) {
        this.phonetics = phonetics;
    }

    @JsonProperty("origin")
    public String getOrigin() {
        return origin;
    }

    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @JsonProperty("meanings")
    public List<Meaning> getMeanings() {
        return meanings;
    }

    @JsonProperty("meanings")
    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

}
