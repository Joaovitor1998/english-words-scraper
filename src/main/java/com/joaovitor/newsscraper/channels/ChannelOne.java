package com.joaovitor.newsscraper.channels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.joaovitor.newsscraper.scrapers.ScraperUtils;

import org.springframework.stereotype.Component;

@Component
public class ChannelOne {
    /*
     * It gets all the news available to return to home page
     */
    private Map<String, String> recentNewsInfo;
    private HtmlPage channelPage;

    public ChannelOne() {
        this.recentNewsInfo = new HashMap<>();
        this.channelPage = ScraperUtils.openWebPage(ChannelConstants.CHANNEL_URL);
    }

    public Map<String, String> getRecentNewsInfo() {
        List<HtmlDivision> newsList = this.channelPage.getByXPath(ChannelConstants.NEWS_LIST_XPATH);

        for (HtmlDivision div : newsList) {
            recentNewsInfo.put(
                    getNewsTitle(div),
                    getNewsHref(div));
        }
        return recentNewsInfo;
    }

    private String getNewsHref(HtmlDivision div) {
        HtmlAnchor href = div.getFirstByXPath(".//a");
        return href.getHrefAttribute();
    }

    private String getNewsTitle(HtmlDivision div) {
        HtmlElement title = div.getFirstByXPath(".//h2");
        return title.asNormalizedText();
    }

    public String convertTitleToHref(String title) {
        for (Map.Entry<String, String> value : this.recentNewsInfo.entrySet()) {

            if (value.getKey().toString().equals(title)) {
                return value.getValue().toString();
            }
        }
        return null;
    }

}
