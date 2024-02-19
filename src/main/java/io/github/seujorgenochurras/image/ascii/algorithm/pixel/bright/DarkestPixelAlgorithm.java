package io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright;

import io.github.seujorgenochurras.image.ascii.algorithm.BrightnessValueCalculator;

import static io.github.seujorgenochurras.util.MathUtils.min;

public class DarkestPixelAlgorithm implements BrightnessValueCalculator {
    @Override
    public int getPixelRepresentation(int red, int green, int blue) {
        return min(red, green, blue);
    }
}
