package com.joaovitor.newsscraper.scrapers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.joaovitor.newsscraper.models.NewsInfo;

@Component
public class NewsInfoScraper {
    
    private HtmlPage page;

    private List<NewsInfo> recentNews = new ArrayList<>();

    public NewsInfoScraper(){
        this.page = ScraperUtils.openWebPage(ScraperConstants.WEBSITE_URL);
        setList();
    }

    public List<NewsInfo> getRecentNews(){
        return this.recentNews;
    }

    private void setList(){
        List<HtmlDivision> newsList = this.page.getByXPath(ScraperConstants.NEWS_LIST);
        long counter = 1L;
        for (HtmlDivision div : newsList) {
            recentNews.add(
                new NewsInfo(
                    getTitle(div),
                    getUrl(div),
                    getCategory(div),
                    counter)
                );
                counter++;
        }
    }

    private String getTitle(HtmlDivision div){
        HtmlElement title = div.getFirstByXPath(ScraperConstants.NEWS_TITLE);
        return title.asNormalizedText();
    }

    private String getUrl(HtmlDivision div){
        HtmlAnchor url = div.getFirstByXPath(ScraperConstants.NEWS_HREF);
        return url.getHrefAttribute();
    }

    private String getCategory(HtmlDivision div){
        String url = this.getUrl(div);
        String category = url.split("/")[3];
        return category;
    }

    public Optional<NewsInfo> getById(Long id){
        for( NewsInfo news : this.recentNews ){
            if( news.getId() == id ) {
                return Optional.of(news);
            }
        }

        return Optional.empty();
    }

}
