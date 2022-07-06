package com.joaovitor.newsscraper.scrapers;

public class ScraperConstants {

    public static final String WEBSITE_URL = "https://abcnews.go.com/";

    public static final String NEWS_LIST = "//div[@class=\"ContentList__Item\"][@role=\"listitem\"]";
    
    public static final String NEWS_TITLE = ".//h2";

    public static final String NEWS_HREF = ".//a";

    public static final String ARTICLE_XPATH = "//*[@id=\"themeProvider\"]/div[2]/span/div/div[1]";
    
    public static final String ARTICLE_HEADER_XPATH = ".//span/div/div[1]/span/div[1]/h1";

    public static final String ARTICLE_CONTENT_XPATH = ".//span/div/div[1]/span/article";
    
}
