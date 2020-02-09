package com.youmuu.connection;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BufferedHTMLReader implements WebReader {
    private String buffer;
    private int cursor;

    @Override
    public boolean setConnection(URL url, String encoding) throws IOException {
        buffer = Jsoup.connect(url.toString()).get().html();
        return true;
    }

    @Override
    public boolean setConnection(String url, String encoding) throws IOException {
        URL urlObj = null;
        urlObj = new URL(url);

        return setConnection(urlObj, encoding);
    }

    @Override
    public void close() throws Exception {
    }

    @Override
    public boolean hasNext() throws IOException {
        return cursor < buffer.length();
    }

    @Override
    public String next() throws IOException {
        return null;
    }

    @Override
    public char nextByte() throws IOException {
        return buffer.charAt(cursor++);
    }
}
