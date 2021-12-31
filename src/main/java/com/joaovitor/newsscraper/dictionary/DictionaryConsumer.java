package com.joaovitor.newsscraper.dictionary;

import com.joaovitor.newsscraper.dictionary.model.Word;
import com.joaovitor.newsscraper.exceptions.NotFoundError;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public abstract class DictionaryConsumer {

    public static Word[] lookUpWord(String word) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.dictionaryapi.dev/api/v2/entries/en/" + word;
        try {
            ResponseEntity<Word[]> wordsEntity = restTemplate.getForEntity(uri, Word[].class);
            return wordsEntity.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("ERROR CAUGHT");
            throw new NotFoundError(word);
        }

    }
}
