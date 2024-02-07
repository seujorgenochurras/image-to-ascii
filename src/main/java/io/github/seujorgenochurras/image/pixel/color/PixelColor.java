package io.github.seujorgenochurras.image.pixel.color;

import java.awt.*;

public class PixelColor {
    private final Color color;

    private final Red red;
    private final Green green;
    private final Blue blue;
    private final Alpha alpha;


    public PixelColor(Color color) {
        this.color = color;

        this.alpha = new Alpha(color.getAlpha());
        this.blue = new Blue(color.getBlue());
        this.red = new Red(color.getRed());
        this.green = new Green(color.getGreen());

    }

    public int getRGB() {
        return instantiateCurrentColor().getRGB();
    }

    /***
     this method is needed to update current color, because the class Color is immutable
     * @return a new color
     */
    public Color instantiateCurrentColor() {
        return new Color(getRed().colorValue, getGreen().colorValue, getBlue().colorValue, getAlpha().colorValue);
    }

    public Red getRed() {
        return red;
    }

    public Green getGreen() {
        return green;
    }

    public Blue getBlue() {
        return blue;
    }

    public Alpha getAlpha() {
        return alpha;
    }

    @Override
    public String toString() {
        return "PixelColor{" +
                "color=" + color +
                ", red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", alpha=" + alpha +
                '}';
    }
}
