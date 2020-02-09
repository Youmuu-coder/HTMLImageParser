package com.youmuu.core.util;

import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ImageInfoConfigurator {
    private static final int SIZE_BUFFER = 16384;

    public static void configure(List<ImageInfo> list) {
        list.forEach(
                x -> {
                    Image image = downloadImage(x);
                    if(image != null) {
                        x.setResolution(image.getHeight() + " x " + image.getWidth());
                    }
                }
        );
    }

    private static Image downloadImage(ImageInfo imageInfo) {
        try(InputStream inputStream = new URL(imageInfo.getUrl()).openStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            int nRead = 0;
            int size = 0;

            byte[] data = new byte[SIZE_BUFFER];

            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                byteArrayOutputStream.write(data, 0, nRead);
                size += nRead;
            }
            imageInfo.setSize(Double.toString((double)size / 1024));
            return new Image(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
