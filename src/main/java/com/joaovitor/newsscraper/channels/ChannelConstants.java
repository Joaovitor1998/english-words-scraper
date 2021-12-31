package com.joaovitor.newsscraper.channels;

public class ChannelConstants {

    public static final String ARTICLE_XPATH = "//article[@class=\"Article__Wrapper\"]";
    public static final String ARTICLE_HEADER_XPATH = ".//h1[@class=\"Article__Headline__Title\"]";
    public static final String ARTICLE_CONTENT_XPATH = ".//section[@class=\"Article__Content story\"]";

    public static final String NEWS_LIST_XPATH = "//div[@class=\"ContentList__Item\"][@role=\"listitem\"]";
    public static final String CHANNEL_URL = "https://abcnews.go.com/";

}
