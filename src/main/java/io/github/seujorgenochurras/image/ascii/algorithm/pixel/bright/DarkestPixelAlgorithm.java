package io.github.seujorgenochurras.image.ascii.algorithm.pixel.bright;

import io.github.seujorgenochurras.image.ascii.algorithm.ParserAlgorithm;

import static io.github.seujorgenochurras.util.MathUtils.min;

public class DarkestPixelAlgorithm implements ParserAlgorithm {
    @Override
    public long getPixelRepresentation(int red, int green, int blue) {
        return min(red, green, blue);
    }
}
