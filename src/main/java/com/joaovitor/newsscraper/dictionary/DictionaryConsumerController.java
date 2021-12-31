package com.joaovitor.newsscraper.dictionary;

import com.joaovitor.newsscraper.dictionary.model.Word;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DictionaryConsumerController {

    @GetMapping("/search/word/{word}")
    public String wordSearcher(Model model, @PathVariable String word) {
        Word[] wordFound = DictionaryConsumer.lookUpWord(word);
        model.addAttribute("words", wordFound);
        return "wordFoundModal";
    }
}
