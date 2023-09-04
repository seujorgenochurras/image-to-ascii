package io.github.seujorgenochurras.image.ascii.algorithm.pixel;

import io.github.seujorgenochurras.image.ascii.algorithm.AsciiParserAlgorithm;

public class AsciiHumanEyeAlgorithm implements AsciiParserAlgorithm {

    @Override
    public long getPixelRepresentation(int red, int green, int blue) {
        return Math.round(red * 0.2126 + green* 0.7152 + blue * 0.0722);
    }
}
