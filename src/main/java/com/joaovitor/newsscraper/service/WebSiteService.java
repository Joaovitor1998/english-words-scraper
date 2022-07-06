package com.joaovitor.newsscraper.service;

import java.util.List;

import com.joaovitor.newsscraper.models.NewsDetails;
import com.joaovitor.newsscraper.models.NewsInfo;
import com.joaovitor.newsscraper.scrapers.NewsDetailsScraper;
import com.joaovitor.newsscraper.scrapers.NewsInfoScraper;

import org.springframework.stereotype.Service;

@Service
public class WebSiteService {

    private NewsInfoScraper info;

    private NewsDetailsScraper details;

    public WebSiteService(NewsInfoScraper info, NewsDetailsScraper details) {
        this.info = info;
        this.details = details;
    }

    // Home Page
    public List<NewsInfo> getListOfRecentNews() {
        return this.info.getRecentNews();
    }

    // Details Page
    public NewsDetails getNewsDetails(Long id) {
        String linkFromId = info.getById(id).get().getUrl();
        this.details.setPage(linkFromId);

        return this.details.getDetails();

    }

}
