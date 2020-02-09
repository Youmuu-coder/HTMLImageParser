package com.youmuu.connection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public interface WebReader extends Reader {
    boolean setConnection(URL url, String encoding) throws IOException;
    boolean setConnection(String url, String encoding) throws IOException;
}
