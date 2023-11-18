package io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright;

import io.github.seujorgenochurras.image.ascii.algorithm.ParserAlgorithm;

public class HumanEyeAlgorithm implements ParserAlgorithm {

    @Override
    public long getPixelRepresentation(int red, int green, int blue) {
        return Math.round(red * 0.2126 + green * 0.7152 + blue * 0.0722);
    }
}
