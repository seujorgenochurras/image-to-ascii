package io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright;

import io.github.seujorgenochurras.image.ascii.algorithm.BrightnessValueCalculator;

import static io.github.seujorgenochurras.util.MathUtils.max;
import static io.github.seujorgenochurras.util.MathUtils.min;

public class LightestAlgorithm implements BrightnessValueCalculator {

    @Override
    public int getPixelRepresentation(int red, int green, int blue) {
        return max(red, green, blue) / 2 + min(red, green, blue) / 2;
    }
}
