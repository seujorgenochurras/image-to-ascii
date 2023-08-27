package io.github.seujorgenochurras.image.pixel;

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
                pixels.add(new Color(image.getRGB(i, j)));
            }
        }
        return pixels;
    }
}
