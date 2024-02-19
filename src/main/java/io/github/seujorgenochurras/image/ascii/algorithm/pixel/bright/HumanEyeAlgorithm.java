package io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright;

import io.github.seujorgenochurras.image.ascii.algorithm.BrightnessValueCalculator;

/**
 * Because of nature, humans have evolved to see some colors better than others.<br>
 * This means that the brightness value of a color is seen by a human according to the color itself
 * and not by just the color intensity.
 */
public class HumanEyeAlgorithm implements BrightnessValueCalculator {

    @Override
    public int getPixelRepresentation(int red, int green, int blue) {
        return Math.toIntExact(Math.round(red * 0.2126 + green * 0.7152 + blue * 0.0722));
    }
}
