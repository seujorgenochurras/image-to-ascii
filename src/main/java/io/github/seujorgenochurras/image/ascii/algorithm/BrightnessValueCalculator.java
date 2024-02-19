package io.github.seujorgenochurras.image.ascii.algorithm;

/**
 * A Calculator that receives rgb values and returns a brightness value.
 */
public interface BrightnessValueCalculator {

    int getPixelRepresentation(int red, int green, int blue);
}

