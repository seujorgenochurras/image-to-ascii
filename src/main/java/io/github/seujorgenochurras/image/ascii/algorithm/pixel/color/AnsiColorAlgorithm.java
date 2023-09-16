package io.github.seujorgenochurras.image.ascii.algorithm.pixel.color;

import io.github.seujorgenochurras.image.pixel.color.PixelColor;

public class AnsiColorAlgorithm implements AsciiColorAlgorithm {

    @Override
    public String getColorRepresentation(PixelColor color) {

        int red = color.getRed().getColorValue();
        int green = color.getGreen().getColorValue();
        int blue = color.getBlue().getColorValue();

        return "\u001B[38;2;" + red + ";" + green + ";" + blue + "m";
    }

}
