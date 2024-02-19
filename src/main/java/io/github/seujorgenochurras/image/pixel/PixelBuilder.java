package io.github.seujorgenochurras.image.pixel;

import io.github.seujorgenochurras.image.BetterImage;

import java.awt.image.BufferedImage;

public class PixelBuilder {
    private PixelBuilder() {
    }

    public static ImagePixelGroup build(BufferedImage image) {
        return new ImagePixelGroup(image);
    }

    public static ImagePixelGroup build(BetterImage betterImage) {
        return build(betterImage.getBufferedImage());
    }
}
