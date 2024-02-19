package io.github.seujorgenochurras.image.pixel;

import io.github.seujorgenochurras.image.pixel.color.PixelColor;

import java.awt.*;

public class ImagePixel {
    public final int x;
    public final int y;
    public final PixelColor color;


    public ImagePixel(Color color, int x, int y) {
        this.color = new PixelColor(color);
        this.x = x;
        this.y = y;
    }

    /**
     * @return color instance of pixel
     */
    public PixelColor getColor() {
        return color;
    }
}