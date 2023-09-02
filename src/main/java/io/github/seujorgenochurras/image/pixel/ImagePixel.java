package io.github.seujorgenochurras.image.pixel;

import io.github.seujorgenochurras.image.pixel.color.PixelColor;
import io.github.seujorgenochurras.util.MathUtils;

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

    public int getBrightestPixel(){
        int red = color.getRed().getColorValue();
        int green = color.getGreen().getColorValue();
        int blue = color.getBlue().getColorValue();

        return MathUtils.max(red, green, blue);
    }

}