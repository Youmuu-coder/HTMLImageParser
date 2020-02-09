package com.youmuu.core.util;

public class ImageInfo {
    private String resolution;
    private String url;
    private String size;

    public ImageInfo(String resolution, String url, String size) {
        this.resolution = resolution;
        this.url = url;
        this.size = size;
    }

    public String getFormat() {
        return resolution;
    }

    public String getUrl() {
        return url;
    }

    public String getSize() {
        return size;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
