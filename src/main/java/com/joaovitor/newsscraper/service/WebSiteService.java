package com.joaovitor.newsscraper.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.joaovitor.newsscraper.channels.ChannelOneDetailsCarrier;
import com.joaovitor.newsscraper.channels.ChannelOneDetails;
import com.joaovitor.newsscraper.channels.ChannelOne;
import com.joaovitor.newsscraper.scrapers.ScraperUtils;

import org.springframework.stereotype.Service;

@Service
public class WebSiteService {

    private ChannelOne channelOne;

    public WebSiteService(ChannelOne channelOne) {
        this.channelOne = channelOne;
    }

    // Home Page
    public Map<String, String> getListOfRecentNews() {
        return channelOne.getRecentNewsInfo();
    }

    // Details Page
    public ChannelOneDetailsCarrier getNewsDetails(String url) {
        String href = channelOne.convertTitleToHref(url);

        ChannelOneDetails details = new ChannelOneDetails();
        details.setPage(href);
        String title = details.getTitle();
        List<String> text = details.getText();
        Set<String> words = ScraperUtils.lookUpForWords(text);
        return new ChannelOneDetailsCarrier(title, text, words);
    }

}
