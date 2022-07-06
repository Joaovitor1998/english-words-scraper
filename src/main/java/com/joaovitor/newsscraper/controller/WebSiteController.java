package com.joaovitor.newsscraper.controller;

import com.joaovitor.newsscraper.models.NewsDetails;
import com.joaovitor.newsscraper.models.NewsInfo;
import com.joaovitor.newsscraper.service.WebSiteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class WebSiteController {

    @Autowired
    private WebSiteService webSiteService;

    @GetMapping
    public List<NewsInfo> homePage() {
        return this.webSiteService.getListOfRecentNews();
    }

    @GetMapping("/{id}")
    public NewsDetails newsDetailsPage(@PathVariable Long id) {

        return webSiteService.getNewsDetails(id);

    }

}
