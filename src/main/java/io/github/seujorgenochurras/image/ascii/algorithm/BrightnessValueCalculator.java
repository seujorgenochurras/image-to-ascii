package io.github.seujorgenochurras.image.ascii.algorithm;

import io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright.Algorithms;

/**
 * A Calculator that receives rgb values and returns a brightness value.
 *
 * @see Algorithms
 */
public interface BrightnessValueCalculator {

    int getPixelRepresentation(int red, int green, int blue);
}

