package com.joaovitor.newsscraper.models;

public class NewsInfo {

    private Long id;
    private String title;
    private String url;
    private String category;

    public NewsInfo(String title, String url, String category, Long id) {
        this.title = title;
        this.url = url;
        this.category = category;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }

    

    
    
}
