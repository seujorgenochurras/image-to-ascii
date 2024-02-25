package io.github.seujorgenochurras.image.ascii.algorithm;

import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;

/**
 * A Calculator that receives rgb values and returns a brightness value.
 *
 * @see Algorithms
 */
public interface BrightnessValueCalculator {

    /**
     * Receives a color and returns its brightness value
     *
     * @param red   red intensity in decimal (0-255)
     * @param green green intensity in decimal (0-255)
     * @param blue  blue intensity in decimal (0-255)
     * @return Brightness value of specified colors
     */
    int getBrightnessValue(int red, int green, int blue);
}

