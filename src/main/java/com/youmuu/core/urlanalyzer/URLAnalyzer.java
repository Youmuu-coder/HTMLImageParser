package com.youmuu.core.urlanalyzer;

import java.net.MalformedURLException;
import java.net.URL;

public class URLAnalyzer {
    private URL source;

    public URLAnalyzer(URL source) {
        this.source = source;
    }

    public boolean isURL(String url){
        try {
            URL type = new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public String configureURL(String url) {
        return source.getProtocol() + "://" + source.getHost() + url;
    }
}
