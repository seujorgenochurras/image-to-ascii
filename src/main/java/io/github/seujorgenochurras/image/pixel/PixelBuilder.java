package io.github.seujorgenochurras.image.pixel;

import io.github.seujorgenochurras.image.Image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PixelBuilder {
    private PixelBuilder() {
    }

    public static ImagePixels build(BufferedImage image) {
        ImagePixels pixels = new ImagePixels();

        final int imageWidth = image.getWidth();
        final int imageHeight = image.getHeight();

        for (int i = 0; i < imageWidth; i++) {
            for (int j = 0; j < imageHeight; j++) {
                Color pixelColor = new Color(image.getRGB(i, j));
                pixels.add(new ImagePixel(pixelColor, i, j));
            }
        }
        return pixels;
    }
    public static ImagePixels build(Image image){
        return build(image.getBufferedImage());
    }
}
