package io.github.seujorgenochurras.image.pixel;

import io.github.seujorgenochurras.image.Image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelBuilder {
    private PixelBuilder() {
    }

    public static ImagePixelGroup build(BufferedImage image) {
        ImagePixelGroup pixels = new ImagePixelGroup();

        final int imageWidth = image.getWidth();
        final int imageHeight = image.getHeight();

        for (int i = 0; i < imageHeight; i++) {
            for (int j = 0; j < imageWidth; j++) {
                Color pixelColor = new Color(image.getRGB(j, i));
                pixels.add(new ImagePixel(pixelColor, j, i));
            }
        }
        return pixels;
    }
    public static ImagePixelGroup build(Image image){
        return build(image.getBufferedImage());
    }
}
