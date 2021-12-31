package com.joaovitor.newsscraper.channels;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.joaovitor.newsscraper.scrapers.ScraperUtils;
import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlArticle;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import com.gargoylesoftware.htmlunit.html.HtmlSection;
import static com.joaovitor.newsscraper.channels.ChannelConstants.*;

import org.springframework.stereotype.Component;

@Component
public class ChannelOneDetails {
    /*
     * It should return the news content to Details Page
     * It should return a title, a text and get the words
     */

    private String title;
    private List<String> text;
    private HtmlPage page;
    private HtmlArticle article;

    public ChannelOneDetails() {
        this.text = new ArrayList<>();
    }

    public void setPage(String url) {
        this.page = ScraperUtils.openWebPage(url);
        this.article = page.getFirstByXPath(ARTICLE_XPATH);
        scrapText();
        scrapTitle();
    }

    public String getTitle() {
        return this.title;
    }

    private void scrapTitle() {
        HtmlHeading1 header = this.article.getFirstByXPath(ChannelConstants.ARTICLE_HEADER_XPATH);
        this.title = header.asNormalizedText();
    }

    public List<String> getText() {
        return this.text;
    }

    private void scrapText() {
        HtmlSection section = this.article.getFirstByXPath(ARTICLE_CONTENT_XPATH);

        List<HtmlParagraph> textAsParagraph = section.getByXPath(".//p");

        for (HtmlParagraph paragraph : textAsParagraph) {
            this.text.add(paragraph.asNormalizedText());
        }
    }

}
