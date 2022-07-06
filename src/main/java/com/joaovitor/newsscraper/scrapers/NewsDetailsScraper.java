package com.joaovitor.newsscraper.scrapers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gargoylesoftware.htmlunit.html.HtmlArticle;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import com.joaovitor.newsscraper.models.NewsDetails;

@Component
public class NewsDetailsScraper {

    private HtmlPage page;

    public NewsDetailsScraper() {
    }

    public void setPage(String url){
        this.page = ScraperUtils.openWebPage(url);
    }

    public NewsDetails getDetails(){
        return new NewsDetails(
            getTitle(),
            getArticle()
        );
    }


    private String getTitle() {

        HtmlHeading1 headerContent = this.page.getFirstByXPath(ScraperConstants.ARTICLE_HEADER_XPATH);

        return headerContent.asNormalizedText();
    }

    private List<String> getArticle() {

        HtmlArticle articleContent = this.page.getFirstByXPath(ScraperConstants.ARTICLE_CONTENT_XPATH);
        List<HtmlParagraph> contentParagraphs = articleContent.getByXPath(".//p");

        List<String> article = new ArrayList<>();

        for(HtmlParagraph paragraph : contentParagraphs){
            article.add(paragraph.asNormalizedText());
        }

        return article;
    }
    
}
