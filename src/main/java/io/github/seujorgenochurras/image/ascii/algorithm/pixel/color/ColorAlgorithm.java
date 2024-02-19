package io.github.seujorgenochurras.image.ascii.algorithm.pixel.color;

import io.github.seujorgenochurras.image.pixel.color.PixelColor;

/**
 * Represents an algorithm for parsing rgb colors in ASCII
 *
 * @see AnsiColorAlgorithm
 */
public interface ColorAlgorithm {
    String getColorRepresentation(PixelColor color);


}
