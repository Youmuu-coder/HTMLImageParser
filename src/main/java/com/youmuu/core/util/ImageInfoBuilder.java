package com.youmuu.core.util;

import java.util.ArrayList;
import java.util.List;

public class ImageInfoBuilder {
    private List<ImageInfo> imageInfoList;

    public ImageInfoBuilder() {
        this.imageInfoList = new ArrayList<>();
    }

    public void newSrc(String src) {
        imageInfoList.add(new ImageInfo(null, src, null));
    }

    public List<ImageInfo> getImageInfoList() {
        List<ImageInfo> result = new ArrayList<>(imageInfoList);
        imageInfoList.clear();
        return result;
    }
}
