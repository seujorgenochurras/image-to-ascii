package io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright;

import io.github.seujorgenochurras.image.ascii.algorithm.BrightnessValueCalculator;

import static io.github.seujorgenochurras.util.MathUtils.max;

public class BrightestAlgorithm implements BrightnessValueCalculator {
    @Override
    public int getPixelRepresentation(int red, int green, int blue) {
        return max(red, blue, green);
    }
}
