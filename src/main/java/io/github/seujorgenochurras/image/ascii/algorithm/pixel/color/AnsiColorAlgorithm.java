package io.github.seujorgenochurras.image.ascii.algorithm.pixel.color;

import io.github.seujorgenochurras.image.pixel.color.PixelColor;

/**
 * Uses the <a href="https://en.wikipedia.org/wiki/ANSI_escape_code">ANSI</a>
 * standard for terminals to colorize the symbol in the rgb format
 */
public class AnsiColorAlgorithm implements ColorAlgorithm {

    @Override
    public String getColorRepresentation(PixelColor color) {

        int red = color.getRed().asDecimal();
        int green = color.getGreen().asDecimal();
        int blue = color.getBlue().asDecimal();

        return "\u001B[38;2;" + red + ";" + green + ";" + blue + "m";
    }

}
