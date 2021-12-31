package com.joaovitor.newsscraper.controller;

import com.joaovitor.newsscraper.channels.ChannelOneDetailsCarrier;
import com.joaovitor.newsscraper.service.WebSiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebSiteController {

    @Autowired
    private WebSiteService webSiteService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("recentNews", webSiteService.getListOfRecentNews());
        return "home";
    }

    @GetMapping("/news/{url}")
    public String newsDetailsPage(@PathVariable String url, Model model) {

        ChannelOneDetailsCarrier info = webSiteService.getNewsDetails(url);

        model.addAttribute("title", info.getTitle());
        model.addAttribute("text", info.getText());
        model.addAttribute("words", info.getWords());
        return "details";
    }

}
